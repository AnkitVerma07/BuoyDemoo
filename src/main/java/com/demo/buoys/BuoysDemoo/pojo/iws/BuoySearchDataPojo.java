package com.demo.buoys.BuoysDemoo.pojo.iws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BuoySearchDataPojo {
	private String lon;
	private String lat;
	private Integer radius;
	
	public BuoySearchDataPojo(){
		
	}
	
	public BuoySearchDataPojo(String lon, String lat, Integer radius){
		this.lon = lon;
		this.lat = lat;
		this.radius = radius;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}
	
	
}
