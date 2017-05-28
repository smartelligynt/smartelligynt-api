package com.smartelligynt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chart {
	private String color;

	private String resourceUrl;

	private String type;

	private String etype;

	@JsonProperty("y")
	private Axis y;

	@JsonProperty("x")
	private Axis x;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEtype() {
		return etype;
	}

	public void setEtype(String etype) {
		this.etype = etype;
	}

	public Axis getY() {
		return y;
	}

	public void setY(Axis y) {
		this.y = y;
	}

	public Axis getX() {
		return x;
	}

	public void setX(Axis x) {
		this.x = x;
	}

	@Override
	public String toString() {
		return "ClassPojo [color = " + color + ", resourceUrl = " + resourceUrl + ", type = " + type + ", etype = "
				+ etype + ", y = " + y + ", x = " + x + "]";
	}
}
