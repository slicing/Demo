package com.slow.oversea.repository;

import com.slow.oversea.dataobject.UniversityCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/17 22:41
 */
public interface UniversityCategoryRepository extends JpaRepository<UniversityCategory,Integer> {


	@Query("select university.countryId from UniversityCategory university where university.universityId = ?1")
	Integer findCountryIdByUniversityId(Integer universityId);

	@Query("SELECT  university.universityName from UniversityCategory university where university.universityId = ?1")
	String findUniversityNameByUniversityId(Integer universityId);
	@Query("SELECT  university from UniversityCategory university where university.countryId = ?1")
	List<UniversityCategory> findUniversityByCountryId(Integer countryId);
	UniversityCategory findByUniversityName(String name);
}
