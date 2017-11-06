package com.demo.buoys.BuoysDemoo.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

import com.demo.buoys.BuoysDemoo.db.entity.Buoy;


/**
 * @author Ankit_Verma
 *
 */
@XmlRootElement
public class UserDataPojo {

	private Integer id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private Boolean success;
	private Collection<Buoy> buoyList = new ArrayList<Buoy>();
	
	public UserDataPojo(){
		
	}
	
	public UserDataPojo(Integer id, String first_name, Boolean success, String last_name, String email, String password, Collection<Buoy> buoyList){
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.buoyList = buoyList;
		this.success = success;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Buoy> getBuoyList() {
		return buoyList;
	}

	public void setBuoyList(Collection<Buoy> buoyList) {
		this.buoyList = buoyList;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	
}
