package com.slow.oversea.repository;

import com.slow.oversea.dataobject.ApplicationTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/19 10:48
 */
public interface ApplicationTableRepository extends JpaRepository<ApplicationTable,Integer> {
	ApplicationTable findByStudentId(Integer studentId);
	/*申请国家*/
	List<ApplicationTable> findByApplicationCountry(String country);
	/*学生所在国籍*/
	List<ApplicationTable> findByStudentCountry(String country);

}
