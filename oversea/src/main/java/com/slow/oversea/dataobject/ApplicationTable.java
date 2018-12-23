package com.slow.oversea.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.slow.oversea.enums.ApplicationStatueEnum;
import com.slow.oversea.utils.Data2LongSerializer;
import com.slow.oversea.utils.EnumUtil;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 申请表
 * @author Slicing
 * @date 2018/12/19 10:15
 */
@Entity
@Data
@Table(name = "application_table")
public class ApplicationTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tableId;
	/*学生ID*/
	private Integer studentId;
	/*学生姓名*/
	private String studentName;
	/*学生国籍*/
	private String studentCountry;
	/*学生大学*/
	private String studentUniversity;
	/*学生专业*/
	private String studentMajor;
	/*申请国家*/
	private String applicationCountry;
	/*申请大学*/
	private String applicationUniversity;
	/*申请专业*/
	private String applicationMajor;
	/*申请状态*/
	private Integer applicationStatue;
	/*创建时间*/
	@JsonSerialize(using = Data2LongSerializer.class)
	private Date createTime;
	/*修改时间*/
	@JsonSerialize(using = Data2LongSerializer.class)
	private Date updateTime;
	@JsonIgnore
	public ApplicationStatueEnum getApplicationStatusEnum(){
		return EnumUtil.getByCode(applicationStatue,ApplicationStatueEnum.class);
	}

}
