package com.slow.shell.form;

import lombok.Data;

/**
 * @author Slicing
 * @date 2018/12/7 18:10
 */
@Data
public class CategoryForm {
	private Integer categoryId;
	/*类目名字name.*/
	private String categoryName;
	/*类目编号type.*/
	private Integer categoryType;
}
