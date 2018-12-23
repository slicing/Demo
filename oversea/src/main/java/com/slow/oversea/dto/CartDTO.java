package com.slow.oversea.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.slow.oversea.enums.ApplicationStatueEnum;
import com.slow.oversea.utils.Data2LongSerializer;
import com.slow.oversea.utils.EnumUtil;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Slicing
 * @date 2018/12/19 18:49
 */
@Data
public class CartDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tableId;
	/*学生姓名*/
	private String studentName;
	/*学生国籍*/
	private String studentCountry;
	/*申请国家*/
	private String applicationCountry;
	/*申请状态*/
	private Integer applicationStatue;
	/*创建时间*/
	@JsonSerialize(using = Data2LongSerializer.class)
	private Date createTime;

	@JsonIgnore
	public ApplicationStatueEnum getApplicationStatusEnum(){
		return EnumUtil.getByCode(applicationStatue,ApplicationStatueEnum.class);
	}
}
