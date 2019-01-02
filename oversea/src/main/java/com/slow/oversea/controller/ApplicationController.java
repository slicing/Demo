package com.slow.oversea.controller;

import com.slow.oversea.dataobject.ApplicationTable;
import com.slow.oversea.dto.CartDTO;
import com.slow.oversea.enums.ResultEnum;
import com.slow.oversea.exception.OverSeaException;
import com.slow.oversea.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Slicing
 * @date 2018/12/19 11:42
 */
@Controller
@RequestMapping("/application")
public class ApplicationController {
	@Autowired
	private ApplicationService applicationService;

	/**
	 * 查询申请表
	 * @param tableId
	 * @return
	 */
	@GetMapping("/get/id")
	public ModelAndView getId(@RequestParam("tableId") Integer tableId,
							  Map<String,Object> map){
		ApplicationTable applicationTable = applicationService.findOne(tableId);
		map.put("applicationTable",applicationTable);
		return new ModelAndView("application/",map);
	}

	/**
	 *列表
	 * @param map
	 * @return
	 */
	@GetMapping("/get/list")
	public ModelAndView getAll(Map<String,Object> map){
		List<CartDTO> cartDTOList = applicationService.findList();
		map.put("cartDTOList",cartDTOList);
		return new ModelAndView("application/list",map);
	}

	/**
	 *详情
	 * @param tableId
	 * @param map
	 * @return
	 */
	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam("tableId") Integer tableId,
							   Map<String,Object> map){
		ApplicationTable applicationTable = new ApplicationTable();
		try{
			applicationTable = applicationService.findOne(tableId);
		}catch (OverSeaException e){
			map.put("msg",e.getMessage());
			map.put("url","/application/get/list");
			return new ModelAndView("common/error",map);
		}
		map.put("applicationTable",applicationTable);
		return new ModelAndView("application/detail",map);
	}

	/**
	 * 驳回
	 * @param tableId
	 * @param map
	 * @return
	 */
	@GetMapping("/reject")
	public ModelAndView reject(@RequestParam("tableId") Integer tableId,
							   Map<String,Object> map){
		try {
			ApplicationTable applicationTable = applicationService.findOne(tableId);
			applicationService.reject(applicationTable);
		}catch (OverSeaException e){
			map.put("msg",e.getMessage());
			map.put("url","/application/get/list");
			return new ModelAndView("/common/error");
		}
		map.put("msg",ResultEnum.APPLICATION_REJECT_SUCCESS);
		map.put("url","/application/get/list");
		return new ModelAndView("common/success",map);
	}

	/**
	 * 审核通过
	 * @param tableId
	 * @param map
	 * @return
	 */
	@GetMapping("/adopt")
	public ModelAndView adopt(@RequestParam("tableId") Integer tableId,
							  Map<String,Object> map){
		try {
			ApplicationTable applicationTable = applicationService.findOne(tableId);
			applicationService.adopt(applicationTable);
		}catch (OverSeaException e){
			map.put("msg",e.getMessage());
			map.put("url","/application/get/list");
			return new ModelAndView("common/error");
		}
		map.put("msg",ResultEnum.APPLICATION_ADOPT_SUCCESS);
		map.put("url","/application/get/list");
		return new ModelAndView("common/success",map);
	}

	/**
	 * 审核中
	 * @param tableId
	 * @param map
	 * @return
	 */
	@GetMapping("/under")
	public ModelAndView under(@RequestParam("tableId") Integer tableId,
							  Map<String,Object> map){
		try {
			ApplicationTable applicationTable = applicationService.findOne(tableId);
			applicationService.under(applicationTable);
		}catch (OverSeaException e){
			map.put("msg",e.getMessage());
			map.put("url","/application/get/list");
			return new ModelAndView("/common/error");
		}
		map.put("msg",ResultEnum.APPLICATION_UNDER_SUCCESS);
		map.put("url","/application/get/list");
		return new ModelAndView("common/success",map);
	}

	/**
	 * 创建申请表
	 * @param map
	 * @param request
	 * @return
	 */
	@Transactional
	@RequestMapping("/create")
	public ModelAndView create(Map<String,Object> map, HttpServletRequest request){
		ApplicationTable applicationTable = new ApplicationTable();
		applicationTable.setStudentId(Integer.parseInt(request.getParameter("studentId")));
		applicationTable.setStudentName(request.getParameter("studentName"));
		applicationTable.setStudentCountry(request.getParameter("studentCountry"));
		applicationTable.setStudentUniversity(request.getParameter("studentUniversity"));
		applicationTable.setStudentMajor(request.getParameter("studentMajor"));
		applicationTable.setApplicationCountry(request.getParameter("applicationCountry"));
		applicationTable.setApplicationUniversity(request.getParameter("applicationUniversity"));
		applicationTable.setApplicationMajor(request.getParameter("applicationMajor"));
		applicationService.save(applicationTable);
		map.put("",applicationService);
		return new ModelAndView();
	}
}
