package com.slow.conversion.dao;

public class Conversions {
	public String conHeight(float height){
		String grade = null;
		if (height <= 150)
			grade = "";
		else if (height > 150 && height <=160)
			grade = "S";
		else if (height >160 && height > 170)
			grade = "M";
		if (height >= 180)
			grade = "L";
		return grade;
	}
	public String conBust(float bust){
		String grade = null;
		if (bust<=75)
			grade = "A";
		else if (bust > 75 && bust <= 85)
			grade = "B";
		else if (bust > 85 && bust <= 100)
			grade = "C";
		else if (bust > 100 && bust <= 115)
			grade = "D";
		if (bust > 115)
			grade = "E";
		return grade;
	}
	public String conWaist(float waist){
		String grade = null;
		if (waist <= 73.5)
			grade = String.valueOf(2.2);
		else if (waist > 73.5 && waist <= 77)
			grade = String.valueOf(2.3);
		else if (waist > 77 && waist <= 80)
			grade = String.valueOf(2.4);
		else if (waist > 80 && waist <= 83.5)
			grade = String.valueOf(2.5);
		else if (waist > 83.5 && waist <= 87)
			grade = String.valueOf(2.6);
		else if (waist > 87 && waist <= 90)
			grade = String.valueOf(2.7);
		else
			grade = String.valueOf(2.8);
		return grade;
	}
	public String conHiple(float heiple){
		String grade = null;
		if (heiple <= 80 )
			grade = String.valueOf(1.9);
		else if (heiple > 80 && heiple <= 83)
			grade = String.valueOf(2.0);
		else if (heiple > 83 && heiple <=  87)
			grade = String.valueOf(2.1);
		else if (heiple > 87 && heiple <= 90)
			grade = String.valueOf(2.2);
		else if (heiple >90 && heiple <95)
			grade = String.valueOf(2.3);
		else
			grade = String.valueOf(2.4);
		return grade;
	}

}
