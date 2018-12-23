package com.slow.oversea.service;

import com.slow.oversea.dataobject.MajorInfo;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/17 22:44
 */
public interface MajorService {
	MajorInfo findOne(Integer id);
	List<MajorInfo> findMajorInfoByUniversityId(Integer universityId);
	List<MajorInfo> findAll();
	MajorInfo save(MajorInfo majorInfo);
	void delete(MajorInfo majorInfo);
}
