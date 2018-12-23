package com.slow.oversea.repository;

import com.slow.oversea.dataobject.MajorInfo;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/17 22:40
 */
public interface MajorInfoRepository extends JpaRepository<MajorInfo,Integer> {
	@Query("Select major from MajorInfo major where major.universityId = ?1 ")
	List<MajorInfo> findMajorInfoByUniversityId(Integer universityId);
	List<MajorInfo> findByMajorId(Integer majorId);
	@Query("select major.majorName from MajorInfo major where major.majorId = ?1 ")
	String findMajorNameByMajorId(Integer majorId);
 }
