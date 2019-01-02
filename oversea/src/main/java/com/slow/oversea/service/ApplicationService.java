package com.slow.oversea.service;

import com.slow.oversea.dataobject.ApplicationTable;
import com.slow.oversea.dto.CartDTO;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/19 11:02
 */
public interface ApplicationService {
	ApplicationTable findOne(Integer id);
	ApplicationTable findByStudentId(Integer studentId);
	List<ApplicationTable> findByApplicationCountry(String name);
	List<ApplicationTable> findByStudentCountry(String name);
	List<CartDTO> findList();
	/*驳回*/
	ApplicationTable reject(ApplicationTable applicationTable);
	/*通过*/
	ApplicationTable adopt(ApplicationTable applicationTable);
	/*正在审核*/
	ApplicationTable under(ApplicationTable applicationTable);

	void save(ApplicationTable applicationTable);
}
