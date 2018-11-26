package com.slow.conversion.controller;

import com.slow.conversion.dao.Conversions;
import com.slow.conversion.dao.SaveSize;
import org.springframework.stereotype.Controller;

@Controller
public class Conversion {

	SaveSize saveSize = new SaveSize();
	Conversions conversions = new Conversions();
	float height = saveSize.save()[0];
	float bust = saveSize.save()[1];
	float waist = saveSize.save()[2];
	float hiple = saveSize.save()[3];
	String[] conSize = new String[4];

	public void conHeigh(){
		conSize[0] = conversions.conHeight(height);
	}
	public void conBust(){
		conSize[1] = conversions.conBust(bust);
	}
	public void conWaist(){
		conSize[2] = conversions.conWaist(waist);
	}
	public void conHiple(){
		conSize[3] = conversions.conHiple(hiple);
	}
}
