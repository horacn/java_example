package com.hz.example.interf.man;

import com.hz.example.interf.man.Wife;

public class Husband {
	private String name;
	private Integer height;
	private Integer weight;
	private String carModel;
	private String yearlySalary;
	private Wife wife;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(String yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	
	
	public void show(){
		if(this.wife == null){
			System.out.println("[Husband] 我的名字："+name+"，身高："+height+"，体重："+weight+"，座驾："+
					carModel+"，年薪："+yearlySalary+"，目前没有妻子");
		}else{
			System.out.println("[Husband] 我的名字："+name+"，身高："+height+"，体重："+weight+"，座驾："+
					carModel+"，年薪："+yearlySalary+"，妻子是："+wife.getName());
		}
	}
	
}
