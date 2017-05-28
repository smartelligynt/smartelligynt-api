package com.smartelligynt.api.model;

public class Device {
	private String unit;

	private String desc;

	private String name;

	private String type;
	
	private String location; //lat long

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ClassPojo [unit = " + unit + ", desc = " + desc + ", name = " + name + ", type = " + type + "]";
	}
}
