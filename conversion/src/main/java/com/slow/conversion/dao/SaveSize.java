package com.slow.conversion.dao;

import com.slow.conversion.model.ConsumerInfo;

public class SaveSize {
	private Float[] sizeInfo=new Float[4];
	ConsumerInfo consumerInfo = new ConsumerInfo();
	public Float[] save(){
		sizeInfo[0] = consumerInfo.getHeight();
		sizeInfo[1] = consumerInfo.getBust();
		sizeInfo[2] = consumerInfo.getWaist();
		sizeInfo[3] = consumerInfo.getHipline();
		return sizeInfo;
	}
	public void setInfo(float height,float bust,float waist,float hipline){
		consumerInfo.setHeight(height);
		consumerInfo.setBust(bust);
		consumerInfo.setWaist(waist);
		consumerInfo.setHipline(hipline);
	}
}
