package com.demo.buoys.BuoysDemoo.information;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.demo.buoys.BuoysDemoo.db.entity.Buoy;
import com.demo.buoys.BuoysDemoo.db.entity.User;
import com.demo.buoys.BuoysDemoo.pojo.iws.BuoyDataPojo;
import com.demo.buoys.BuoysDemoo.pojo.iws.ResponseBuoyList;
import com.demo.buoys.BuoysDemoo.pojo.iws.UserCredentials;
import com.demo.buoys.BuoysDemoo.pojo.iws.UserDataPojo;
import com.demo.buoys.BuoysDemoo.repository.UserRepo;

public class UserInformation {

	private UserRepo userRepo;
	private User userEntity;
	
	
	public void InsertUserInfo(UserDataPojo userData) {
		userEntity = new User();
		userEntity.setFirst_name(userData.getFirst_name());
		userEntity.setLast_name(userData.getLast_name());
		userEntity.setEmail(userData.getEmail());
		userEntity.setPassword(userData.getPassword());
		userRepo = new UserRepo();
		userRepo.InsertUserData(userEntity);
	}

	public UserDataPojo getUserInfo(int id) {
		userRepo = new UserRepo();
		userEntity = new User();
		UserDataPojo userpojo = new UserDataPojo();
		userEntity = userRepo.getUserData(id);
		userpojo.setId(userEntity.getId());
		userpojo.setFirst_name(userEntity.getFirst_name());
		userpojo.setLast_name(userEntity.getLast_name());
		userpojo.setEmail(userEntity.getEmail());
		userpojo.setPassword(userEntity.getPassword());
		return userpojo;
	}
	
	
	public void UpdateUser(UserDataPojo userData) {
		userEntity = new User();
		userRepo = new UserRepo();
		int id = userData.getId();
		userEntity = userRepo.getUserData(id);
		if(userData.getFirst_name() == null){
			userEntity.setFirst_name(userEntity.getFirst_name());
		} else {
			userEntity.setFirst_name(userData.getFirst_name());
		}
		if(userData.getLast_name() == null){
			userEntity.setLast_name(userEntity.getLast_name());
		} else {
			userEntity.setLast_name(userData.getLast_name());
		}
		if(userData.getEmail() == null){
			userEntity.setEmail(userEntity.getEmail());
		} else {
			userEntity.setEmail(userData.getEmail());
		}
		if(userData.getPassword() == null){
			userEntity.setPassword(userEntity.getPassword());
		} else {
			userEntity.setPassword(userData.getPassword());
		}
		userRepo = new UserRepo();
		userRepo.updateUserdata(userEntity);
	}

	public Integer getUserIdByEmail(String email) {
		userEntity = new User();
		userRepo = new UserRepo();
		Integer id = 0;
		List<User> userData = new ArrayList<User>();
		userData = userRepo.LocateUserByEmail(email);
		if(userData.isEmpty()){
			return null;
		}
		for(User users : userData){
			id = users.getId();
		} 
		return id;
	}
	
	public Boolean getUserByEmail(String email) {
		userEntity = new User();
		userRepo = new UserRepo();
		Integer id = 0;
		Boolean value = null;
		List<User> userData = new ArrayList<User>();
		userData = userRepo.LocateUserByEmail(email);
		if(userData.isEmpty()){
			value = false;
		}
		for(User users : userData){
			id = users.getId();
			value = true;
		} 
		return value;
	}

	public String loginValidation(String email, String password) {
		userEntity = new User();
		userRepo = new UserRepo();
		List<User> users = new ArrayList<User>();
		users = userRepo.LocateUserByEmail(email);
		if(users.isEmpty()){
			return "Email does not exist";
		}
		for(User user : users){
			if(user.getPassword().equals(password)){
				String pass = user.getId().toString();
				user.setSuccess(true);
				userRepo = new UserRepo();
				userRepo.updateUserdata(user);
				return pass;
			} else{
				user.setSuccess(false);
				userRepo = new UserRepo();
				userRepo.updateUserdata(user);
				return "wrong password..";
			}
		} 
		
		return "nothing worked..";
	}

	public ResponseBuoyList getUserFavList(int id) {
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		Collection<Buoy> list = new ArrayList<Buoy>();
		List<BuoyDataPojo> returnList = new ArrayList<BuoyDataPojo>();
		List<Buoy> buoyList = new ArrayList<Buoy>();
		list = userEntity.getBuoyList();
		for(Buoy b : list){
			buoyList.add(b);
		}
		for(Buoy b : buoyList){
			BuoyDataPojo buoyDataPojo = new BuoyDataPojo();
			buoyDataPojo.setId(b.getId());
			buoyDataPojo.setStation_id(b.getStation_id());
			buoyDataPojo.setStation_location(b.getStation_location());
			buoyDataPojo.setDate(b.getDate());
			buoyDataPojo.setWindDirection(b.getWindDirection());
			buoyDataPojo.setWindSpeed(b.getWindSpeed());
			buoyDataPojo.setWindGust(b.getWindGust());
			buoyDataPojo.setSignificantWaveHeight(b.getSignificantWaveHeight());
			buoyDataPojo.setDominantWavePeriod(b.getDominantWavePeriod());
			buoyDataPojo.setAveragePeriod(b.getAveragePeriod());
			buoyDataPojo.setMeanWaveDirection(b.getMeanWaveDirection());
			buoyDataPojo.setAtmospherePressure(b.getAtmospherePressure());
			buoyDataPojo.setAirTemperature(b.getAirTemperature());
			buoyDataPojo.setWaterTemperature(b.getWaterTemperature());
			buoyDataPojo.setLocation(b.getLocation());
			buoyDataPojo.setPressureTendency(b.getPressureTendency());
			buoyDataPojo.setDewPoint(b.getDewPoint());
			returnList.add(buoyDataPojo);
		}
		ResponseBuoyList lists = new ResponseBuoyList();
		lists.setList(returnList);
		return lists;
	}

}
