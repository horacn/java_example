package com.hz.example.interf.man;

import com.hz.example.interf.man.Husband;
import com.hz.example.interf.man.Wife;

public class TestWifeAndHusband {
	public static void main(String[] args) {
		
		Husband husband = new Husband();
		husband.setCarModel("大众");
		husband.setHeight(178);
		husband.setName("Jack");
		husband.setWeight(70);
		husband.setYearlySalary("20W");
		
		
		Wife wife = new Wife();
		wife.setHeight(162);
		wife.setName("Linda");
		wife.setWeight(48);
		wife.setBwh("78 58 88");
		wife.setFaceScore("中上");
		wife.setHusband(husband);
		wife.show();
		
		husband.setWife(wife);
		husband.show();
		
		System.out.println(husband.getWife().getHusband().getWife().getHusband().getName());
	}
}
