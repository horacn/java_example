package com.hz.example.interf.man;

public class Wife {
	private String name;
	private String faceScore;
	private Integer height;
	private Integer weight;
	private String bwh;
	private Husband husband;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFaceScore() {
		return faceScore;
	}
	public void setFaceScore(String faceScore) {
		this.faceScore = faceScore;
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
	public String getBwh() {
		return bwh;
	}
	public void setBwh(String bwh) {
		this.bwh = bwh;
	}
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
	
	public String show(){
		if(this.husband == null){
			System.out.println("[Wife] 我的名字："+name+"，身高："+height+"，体重："+weight+"，颜值："+
					faceScore+"，三围："+bwh+"，目前没有丈夫");
			return "[Wife] 我的名字："+name+"，身高："+height+"，体重："+weight+"，颜值："+
			faceScore+"，三围："+bwh+"，目前没有丈夫";
		}else{
			System.out.println("[Wife] 我的名字："+name+"，身高："+height+"，体重："+weight+"，颜值："+
					faceScore+"，三围："+bwh+"，丈夫："+husband.getName());
			return "[Wife] 我的名字："+name+"，身高："+height+"，体重："+weight+"，颜值："+
					faceScore+"，三围："+bwh+"，丈夫："+husband.getName();
		}
	}
	
	
	@Override
	public String toString() {
		return show();
	}

}
