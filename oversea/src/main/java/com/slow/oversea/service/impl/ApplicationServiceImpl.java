package com.slow.oversea.service.impl;

import com.slow.oversea.converter.ApplicationTableTCardDTOConverter;
import com.slow.oversea.dataobject.ApplicationTable;
import com.slow.oversea.dto.CartDTO;
import com.slow.oversea.enums.ApplicationStatueEnum;
import com.slow.oversea.enums.ResultEnum;
import com.slow.oversea.exception.OverSeaException;
import com.slow.oversea.repository.ApplicationTableRepository;
import com.slow.oversea.service.ApplicationService;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/19 11:06
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
	private ApplicationTableRepository repository;

	/**
	 *
	 * @param id
	 * @return
	 */
	@Override
	public ApplicationTable findOne(Integer id) {
		return repository.getOne(id);
	}

	/**
	 *
	 * @param studentId
	 * @return
	 */
	@Override
	public ApplicationTable findByStudentId(Integer studentId) {
		return repository.findByStudentId(studentId);
	}

	/**
	 *
	 * @param name
	 * @return
	 */
	@Override
	public List<ApplicationTable> findByApplicationCountry(String name) {
		return repository.findByApplicationCountry(name);
	}

	/**
	 *
	 * @param name
	 * @return
	 */
	@Override
	public List<ApplicationTable> findByStudentCountry(String name) {
		return repository.findByStudentCountry(name);
	}

	/**
	 *
	 * @return
	 */
	@Override
	public List<CartDTO> findList() {
		List<ApplicationTable> applicationTableList = repository.findAll();
		List<CartDTO> cartDTOList = ApplicationTableTCardDTOConverter.convert(applicationTableList);
		return cartDTOList;
	}

	/**
	 * 驳回
	 * @param applicationTable
	 * @return
	 */

	@Override
	public ApplicationTable reject(ApplicationTable applicationTable) {
		if (!applicationTable.getApplicationStatue().equals(ApplicationStatueEnum.IN_AUDIT.getCode()))
			throw new OverSeaException(ResultEnum.APPLICATION_STATUE_ERROR);
		applicationTable.setApplicationStatue(ApplicationStatueEnum.REJECT.getCode());
		ApplicationTable table = repository.save(applicationTable);
		if (table == null)
			throw new OverSeaException(ResultEnum.APPLICATION_UPDATE_FAIL);
		return applicationTable;

	}

	/**
	 * 审核通过
	 * @param applicationTable
	 * @return
	 */

	@Override
	public ApplicationTable adopt(ApplicationTable applicationTable) {
		if (!applicationTable.getApplicationStatue().equals(ApplicationStatueEnum.IN_AUDIT.getCode()))
			throw new OverSeaException(ResultEnum.APPLICATION_STATUE_ERROR);
		applicationTable.setApplicationStatue(ApplicationStatueEnum.AUDIT_PASS.getCode());
		ApplicationTable table = repository.save(applicationTable);
		if (table == null)
			throw new OverSeaException(ResultEnum.APPLICATION_UPDATE_FAIL);
		return applicationTable;
	}

	/**
	 * 审核中
	 * @param applicationTable
	 * @return
	 */
	@Override
	public ApplicationTable under(ApplicationTable applicationTable) {
		if (!applicationTable.getApplicationStatue().equals(ApplicationStatueEnum.WAIT_EXAMINE.getCode()))
			throw new OverSeaException(ResultEnum.APPLICATION_STATUE_ERROR);
		applicationTable.setApplicationStatue(ApplicationStatueEnum.IN_AUDIT.getCode());
		ApplicationTable table = repository.save(applicationTable);
		if (table == null)
			throw new OverSeaException(ResultEnum.APPLICATION_UPDATE_FAIL);
		return applicationTable;
	}

	/**
	 * 保存
	 * @param applicationTable
	 */

	@Override
	public void save(ApplicationTable applicationTable) {
		repository.save(applicationTable);
	}


}
