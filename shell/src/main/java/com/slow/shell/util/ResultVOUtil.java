package com.slow.shell.util;

import com.slow.shell.vo.ResultVO;

/**
 * @author Slicing
 * @date 2018/12/2 12:47
 */
public class ResultVOUtil {
	public static ResultVO success(Object object){
		ResultVO resultVO = new ResultVO();
		resultVO.setData(object);
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		return resultVO;
	}
	public static ResultVO success(){
		return success(null);
	}
	public static ResultVO error(Integer code,String msg){
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(code);
		resultVO.setMsg(msg);
		return resultVO;
	}
}
