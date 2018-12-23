package com.slow.oversea.service.impl;

import com.slow.oversea.dataobject.MajorInfo;
import com.slow.oversea.repository.MajorInfoRepository;
import com.slow.oversea.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/17 22:47
 */
@Service
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorInfoRepository repository;
	@Override
	public MajorInfo findOne(Integer majorId) {
		return repository.getOne(majorId);
	}

	@Override
	public List<MajorInfo> findMajorInfoByUniversityId(Integer universityId) {
		return repository.findMajorInfoByUniversityId(universityId);
	}


	@Override
	public List<MajorInfo> findAll() {
		return repository.findAll();
	}

	@Override
	public MajorInfo save(MajorInfo majorInfo) {
		return repository.save(majorInfo);
	}


	@Override
	public void delete(MajorInfo majorInfo) {
		repository.delete(majorInfo);
	}
}
