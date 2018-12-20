package com.slow.oversea.dataobject;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Slicing
 * @date 2018/12/17 22:33
 */
@Data
@Entity
@Table(name = "major_info")
public class MajorInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer majorId;

	private String majorName;

	private Integer universityId;

	public MajorInfo() {
	}

	public MajorInfo(Integer majorId, String majorName, Integer universityId) {
		this.majorId = majorId;
		this.majorName = majorName;
		this.universityId = universityId;
	}
}
