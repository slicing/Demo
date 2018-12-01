package com.slow.shell.dataobject;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 类目
 * @author Slicing
 * @date 2018/12/1 13:08
 */
@Entity
@DynamicUpdate
@Table(name = "product_category")
public class ProductCategory {
	/*类目id.*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	/*类目名字name.*/
	private String categoryName;
	/*类目编号type.*/
	private Integer categoryType;
	private Date createTime;
	private Date updateTime;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

	@Override
	public String toString() {
		return "ProductCatrgory{" +
				"categoryId=" + categoryId +
				", categoryName='" + categoryName + '\'' +
				", categoryType=" + categoryType +
				'}';
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
