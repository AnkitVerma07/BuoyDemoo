/**
 * 
 */
package com.demo.buoys.BuoysDemoo.test;

import java.util.ArrayList;
import java.util.List;

import com.demo.buoys.BuoysDemoo.iws.UserInformationIWS;
import com.demo.buoys.BuoysDemoo.pojo.iws.BuoyDataPojo;
import com.demo.buoys.BuoysDemoo.pojo.iws.UserCredentials;
import com.demo.buoys.BuoysDemoo.pojo.iws.UserDataPojo;
import com.demo.buoys.BuoysDemoo.service.FeedReader;

/**
 * @author Ankit_Verma
 *
 */
public class MainTest {

	/**
	 * @param args
	 */
	
	private static UserDataPojo userData;
	private static UserCredentials userC;
	private static UserInformationIWS userIWS;
	private static FeedReader feed;
	
	public static void main(String[] args) {
		testInsertUser();
		//testEmailExists();
		//testValidateLogin();
		//testParseFeed();
	}

//	private static void testParseFeed() {
//		feed = new FeedReader();
//		List<BuoyDataPojo> buoyList = new ArrayList<BuoyDataPojo>();
//		buoyList = feed.insertParseFeed("http://www.ndbc.noaa.gov/rss/ndbc_obs_search.php?lat=40N&lon=73W&radius=100");
//		for(BuoyDataPojo b : buoyList){
//			System.out.println(b.getStation_id());
//			System.out.println(b.getWindSpeed());
//		}
//		
//	}

	private static void testValidateLogin() {
		userIWS = new UserInformationIWS();
		userC = new UserCredentials();
		userC.setEmail("ankibunkers@gmail.com");
		userC.setPassword("wow");
		userIWS.validateLogin("","");
		
	}

	private static void testEmailExists() {
		userIWS = new UserInformationIWS();
		System.out.println(userIWS.locateEmail("ankibunkers@gmail.com"));
	}

	private static void testInsertUser() {
		userData = new UserDataPojo();
		userData.setFirst_name("Ankit");
		userData.setLast_name("Verma");
		userData.setEmail("a");
		userData.setPassword("demo");
		userIWS = new UserInformationIWS();
		userIWS.userInformationPojo(userData);
		
	}

}
