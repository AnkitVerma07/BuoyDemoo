package com.demo.buoys.BuoysDemoo.information;

import java.util.ArrayList;
import java.util.List;

import com.demo.buoys.BuoysDemoo.db.entity.Buoy;
import com.demo.buoys.BuoysDemoo.db.entity.User;
import com.demo.buoys.BuoysDemoo.pojo.iws.BuoyDataPojo;
import com.demo.buoys.BuoysDemoo.pojo.iws.BuoySearchDataPojo;
import com.demo.buoys.BuoysDemoo.pojo.iws.ResponseBuoyList;
import com.demo.buoys.BuoysDemoo.repository.BuoyRepo;
import com.demo.buoys.BuoysDemoo.service.FeedReader;
import com.demo.buoys.BuoysDemoo.repository.UserRepo;

public class BuoyInformation {

	private BuoyRepo buoyrepo;
	private Buoy buoyEntity;
	private FeedReader feeds;
	private BuoySearchDataPojo buoySearch;
	private User userEntity;
	private UserRepo userrepo;
	private BuoyDataPojo buoyDataPojo;
	
	public void InsertBuoyInfo(BuoyDataPojo buoyData) {
		buoyEntity = new Buoy();
		buoyEntity.setDate(buoyData.getDate());
		buoyEntity.setStation_id(buoyData.getStation_id());
		buoyEntity.setStation_location(buoyData.getStation_location());
		buoyEntity.setWindDirection(buoyData.getWindDirection());
		buoyEntity.setWindSpeed(buoyData.getWindSpeed());
		buoyEntity.setWindGust(buoyData.getWindGust());
		buoyEntity.setSignificantWaveHeight(buoyData.getSignificantWaveHeight());
		buoyEntity.setDominantWavePeriod(buoyData.getDominantWavePeriod());
		buoyEntity.setAveragePeriod(buoyData.getAveragePeriod());
		buoyEntity.setMeanWaveDirection(buoyData.getMeanWaveDirection());
		buoyEntity.setAtmospherePressure(buoyData.getAtmospherePressure());
		buoyEntity.setAirTemperature(buoyData.getAirTemperature());
		buoyEntity.setWaterTemperature(buoyData.getWaterTemperature());
		buoyEntity.setLocation(buoyData.getLocation());
		buoyEntity.setPressureTendency(buoyData.getPressureTendency());
		buoyEntity.setDewPoint(buoyData.getDewPoint());
		buoyrepo = new BuoyRepo();
		buoyrepo.InsertBuoyData(buoyEntity);
	}

	
	
	public BuoyDataPojo getBuoyInfo(String id) {
		buoyrepo = new BuoyRepo();
		buoyEntity = new Buoy();
		buoyDataPojo = new BuoyDataPojo();
		List<Buoy> lists = new ArrayList<Buoy>();
		lists = buoyrepo.getBuoyDataByStationId(id);
		for(Buoy b : lists){
			buoyEntity = b;
		}
		buoyDataPojo.setId(buoyEntity.getId());
		buoyDataPojo.setStation_id(buoyEntity.getStation_id());
		buoyDataPojo.setStation_location(buoyEntity.getStation_location());
		buoyDataPojo.setDate(buoyEntity.getDate());
		buoyDataPojo.setWindDirection(buoyEntity.getWindDirection());
		buoyDataPojo.setWindSpeed(buoyEntity.getWindSpeed());
		buoyDataPojo.setWindGust(buoyEntity.getWindGust());
		buoyDataPojo.setSignificantWaveHeight(buoyEntity.getSignificantWaveHeight());
		buoyDataPojo.setDominantWavePeriod(buoyEntity.getDominantWavePeriod());
		buoyDataPojo.setAveragePeriod(buoyEntity.getAveragePeriod());
		buoyDataPojo.setMeanWaveDirection(buoyEntity.getMeanWaveDirection());
		buoyDataPojo.setAtmospherePressure(buoyEntity.getAtmospherePressure());
		buoyDataPojo.setAirTemperature(buoyEntity.getAirTemperature());
		buoyDataPojo.setWaterTemperature(buoyEntity.getWaterTemperature());
		buoyDataPojo.setLocation(buoyEntity.getLocation());
		buoyDataPojo.setPressureTendency(buoyEntity.getPressureTendency());
		buoyDataPojo.setDewPoint(buoyEntity.getDewPoint());
		return buoyDataPojo;
	}
	
	public BuoyDataPojo getBuoy(int id) {
		buoyrepo = new BuoyRepo();
		buoyEntity = new Buoy();
		buoyDataPojo = new BuoyDataPojo();
		buoyEntity = buoyrepo.getBuoyData(id);
		buoyDataPojo.setId(buoyEntity.getId());
		buoyDataPojo.setStation_id(buoyEntity.getStation_id());
		buoyDataPojo.setStation_location(buoyEntity.getStation_location());
		buoyDataPojo.setDate(buoyEntity.getDate());
		buoyDataPojo.setWindDirection(buoyEntity.getWindDirection());
		buoyDataPojo.setWindSpeed(buoyEntity.getWindSpeed());
		buoyDataPojo.setWindGust(buoyEntity.getWindGust());
		buoyDataPojo.setSignificantWaveHeight(buoyEntity.getSignificantWaveHeight());
		buoyDataPojo.setDominantWavePeriod(buoyEntity.getDominantWavePeriod());
		buoyDataPojo.setAveragePeriod(buoyEntity.getAveragePeriod());
		buoyDataPojo.setMeanWaveDirection(buoyEntity.getMeanWaveDirection());
		buoyDataPojo.setAtmospherePressure(buoyEntity.getAtmospherePressure());
		buoyDataPojo.setAirTemperature(buoyEntity.getAirTemperature());
		buoyDataPojo.setWaterTemperature(buoyEntity.getWaterTemperature());
		buoyDataPojo.setLocation(buoyEntity.getLocation());
		buoyDataPojo.setPressureTendency(buoyEntity.getPressureTendency());
		buoyDataPojo.setDewPoint(buoyEntity.getDewPoint());
		return buoyDataPojo;
	}

	public ResponseBuoyList getBuoyList(String lon,String lat,int radius) {
		List<BuoyDataPojo> buoyList = new ArrayList<BuoyDataPojo>();
		ResponseBuoyList list = new ResponseBuoyList();
		String url = "http://www.ndbc.noaa.gov/rss/ndbc_obs_search.php?lat="+ lat +"&lon="+ lon +"&radius="+radius;
		feeds = new FeedReader();
		buoyList = feeds.insertParseFeed(url);
		list.setList(buoyList);
		return list;
	}



	public void InsertFavBuoyInfo(int userId, int buoyId) {
		userEntity = new User();
		buoyEntity = new Buoy();
		userrepo = new UserRepo();
		buoyrepo = new BuoyRepo();
		userEntity = userrepo.getUserData(userId);
		buoyEntity = buoyrepo.getBuoyData(buoyId);
		userEntity.getBuoyList().add(buoyEntity);
		buoyrepo = new BuoyRepo();
		buoyrepo.InsertFavBuoyData(buoyEntity, userEntity);
	}

}
