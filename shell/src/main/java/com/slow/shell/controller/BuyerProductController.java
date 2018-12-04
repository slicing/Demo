package com.slow.shell.controller;

import com.slow.shell.dataobject.ProductCategory;
import com.slow.shell.dataobject.ProductInfo;
import com.slow.shell.service.CategoryService;
import com.slow.shell.service.ProductService;
import com.slow.shell.util.ResultVOUtil;
import com.slow.shell.vo.ProductInfoVO;
import com.slow.shell.vo.ProductVO;
import com.slow.shell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @author Slicing
 * @date 2018/12/2 10:37
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list")
	public ResultVO list(){
		//1.查询所有上架商品
		List<ProductInfo> productInfoList = productService.findUpAll();
		//2.查询类目（一次性查询）
		/*List<Integer> categoryTypeList = new ArrayList<>();
		for (ProductInfo productInfo : productInfoList)
			categoryTypeList.add(productInfo.getCategoryType());*/
		List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
		List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

		//3.数据拼装
		List<ProductVO> productVOList = new ArrayList<>();
		for (ProductCategory productCategory : productCategoryList){
			ProductVO productVO = new ProductVO();
			productVO.setCategoryType(productCategory.getCategoryType());
			productVO.setCategoryName(productCategory.getCategoryName());

			List<ProductInfoVO> productInfoVOList = new ArrayList<>();
			for (ProductInfo productInfo : productInfoList){
				if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
					ProductInfoVO productInfoVO = new ProductInfoVO();
					BeanUtils.copyProperties(productInfo,productInfoVO);
					productInfoVOList.add(productInfoVO);
				}
			}
			productVO.setProductInfoVOList(productInfoVOList);
			productVOList.add(productVO);
		}

		return ResultVOUtil.success(productVOList);
	}
}
