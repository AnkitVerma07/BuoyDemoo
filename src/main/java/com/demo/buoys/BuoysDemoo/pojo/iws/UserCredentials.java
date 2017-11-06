package com.demo.buoys.BuoysDemoo.pojo.iws;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ankit_Verma
 *
 */
@XmlRootElement
public class UserCredentials {

	private String email;
	private String password;
	
	public UserCredentials(){
		
	}
	
	public UserCredentials(String email, String password){
		this.email = email;
		this.password = password;
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
	
}
