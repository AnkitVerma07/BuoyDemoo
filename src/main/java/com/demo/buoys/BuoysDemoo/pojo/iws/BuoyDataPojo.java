package com.demo.buoys.BuoysDemoo.pojo.iws;


import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import com.demo.buoys.BuoysDemoo.db.entity.User;


/**
 * @author Ankit_Verma
 *
 */
@XmlRootElement
public class BuoyDataPojo {

	private Integer id;
	private String station_id;
	private String station_location;
	private String date;
	private String windDirection;
	private String windSpeed;
	private String windGust;
	private String significantWaveHeight;
	private String dominantWavePeriod;
	private String averagePeriod;
	private String meanWaveDirection;
	private String atmospherePressure;
	private String airTemperature;
	private String waterTemperature;
	private String location;
	private String pressureTendency;
	private String dewPoint;
	private Collection<User> userList = new ArrayList<User>();
	
	public BuoyDataPojo(){
		
	}
	
	public BuoyDataPojo(Integer id, String station_id, String dewPoint, String pressureTendency, String station_location, String date, String windDirection, String windSpeed, String windGust, String significantWaveHeight, String dominantWavePeriod, String averagePeriod, String meanWaveDirection, String atmospherePressure, String airTemperature, String waterTemperature,  Collection<User> userList){
		this.id = id;
		this.station_id = station_id;
		this.station_location = station_location;
		this.date = date;
		this.windDirection = windDirection;
		this.windSpeed = windSpeed;
		this.windGust = windGust;
		this.significantWaveHeight = significantWaveHeight;
		this.dominantWavePeriod = dominantWavePeriod;
		this.averagePeriod = averagePeriod;
		this.meanWaveDirection = meanWaveDirection;
		this.atmospherePressure = atmospherePressure;
		this.airTemperature = airTemperature;
		this.waterTemperature = waterTemperature;
		this.userList = userList;
		this.pressureTendency = pressureTendency;
		this.dewPoint = dewPoint;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStation_id() {
		return station_id;
	}

	public void setStation_id(String station_id) {
		this.station_id = station_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWindGust() {
		return windGust;
	}

	public void setWindGust(String windGust) {
		this.windGust = windGust;
	}

	public String getSignificantWaveHeight() {
		return significantWaveHeight;
	}

	public void setSignificantWaveHeight(String significantWaveHeight) {
		this.significantWaveHeight = significantWaveHeight;
	}

	public String getDominantWavePeriod() {
		return dominantWavePeriod;
	}

	public void setDominantWavePeriod(String dominantWavePeriod) {
		this.dominantWavePeriod = dominantWavePeriod;
	}

	public String getAveragePeriod() {
		return averagePeriod;
	}

	public void setAveragePeriod(String averagePeriod) {
		this.averagePeriod = averagePeriod;
	}

	public String getMeanWaveDirection() {
		return meanWaveDirection;
	}

	public void setMeanWaveDirection(String meanWaveDirection) {
		this.meanWaveDirection = meanWaveDirection;
	}

	public String getAtmospherePressure() {
		return atmospherePressure;
	}

	public void setAtmospherePressure(String atmospherePressure) {
		this.atmospherePressure = atmospherePressure;
	}

	public String getAirTemperature() {
		return airTemperature;
	}

	public void setAirTemperature(String airTemperature) {
		this.airTemperature = airTemperature;
	}

	public String getWaterTemperature() {
		return waterTemperature;
	}

	public void setWaterTemperature(String waterTemperature) {
		this.waterTemperature = waterTemperature;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Collection<User> getUserList() {
		return userList;
	}

	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}

	public String getStation_location() {
		return station_location;
	}

	public void setStation_location(String station_location) {
		this.station_location = station_location;
	}

	public String getPressureTendency() {
		return pressureTendency;
	}

	public void setPressureTendency(String pressureTendency) {
		this.pressureTendency = pressureTendency;
	}

	public String getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(String dewPoint) {
		this.dewPoint = dewPoint;
	}
	
	
}
