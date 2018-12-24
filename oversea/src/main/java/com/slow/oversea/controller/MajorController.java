package com.slow.oversea.controller;

import com.slow.oversea.dataobject.MajorInfo;
import com.slow.oversea.dataobject.UniversityCategory;
import com.slow.oversea.enums.ResultEnum;
import com.slow.oversea.exception.OverSeaException;
import com.slow.oversea.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author Slicing
 * @date 2018/12/22 0:19
 */
@Controller
@RequestMapping("/major")
public class MajorController {
	@Autowired
	private MajorService majorService;

	/**
	 * 专业列表
	 * @param universityId
	 * @param map
	 * @return
	 */
	@GetMapping("/university/major/list")
	public ModelAndView getStudentList(@RequestParam(value = "universityId") Integer universityId,
								Map<String,Object> map){
		List<MajorInfo> majorInfoList = majorService.findMajorInfoByUniversityId(universityId);
		map.put("majorInfoList",majorInfoList);
		return new ModelAndView("student/major",map);
	}

	/**
	 * 客户端
	 * 专业列表
	 * @param universityId
	 * @param map
	 * @return
	 */
	@GetMapping("/university/list")
	public ModelAndView getList(@RequestParam(value = "universityId") Integer universityId,
								Map<String,Object> map){
		List<MajorInfo> majorInfoList = majorService.findMajorInfoByUniversityId(universityId);
		map.put("majorInfoList",majorInfoList);
		return new ModelAndView("country/major",map);
	}

	/**
	 * 删除
	 * @param majorId
	 * @param map
	 * @return
	 */
	@PutMapping("/delete")
	public ModelAndView delete(@RequestParam(value = "majorId") Integer majorId,
							   Map<String,Object> map){
		try {
			MajorInfo majorInfo = majorService.findOne(majorId);
			majorService.delete(majorInfo);
		}catch (OverSeaException e){
			map.put("msg",e.getMessage());
			map.put("url","/oversea/university/list");
			return new ModelAndView("common/error");
		}
		map.put("msg",ResultEnum.COUNTRY_CATEGORY_DELETE_SUCCESS);
		map.put("url","/oversea/university/list");
		return new ModelAndView("common/success",map);

	}
}
