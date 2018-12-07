package com.slow.shell.dataobject;

import lombok.Data;
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
@Data
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

	public ProductCategory() {
	}

	public ProductCategory(String categoryName, Integer categoryType) {
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}
}
