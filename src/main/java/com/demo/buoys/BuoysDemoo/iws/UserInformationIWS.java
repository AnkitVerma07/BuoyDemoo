package com.demo.buoys.BuoysDemoo.iws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.demo.buoys.BuoysDemoo.db.entity.User;
import com.demo.buoys.BuoysDemoo.information.BuoyInformation;
import com.demo.buoys.BuoysDemoo.information.UserInformation;
import com.demo.buoys.BuoysDemoo.pojo.iws.ResponseBuoyList;
import com.demo.buoys.BuoysDemoo.pojo.iws.UserCredentials;
import com.demo.buoys.BuoysDemoo.pojo.iws.UserDataPojo;
import com.demo.buoys.BuoysDemoo.repository.UserRepo;

/**
 * @author Ankit_Verma
 * restful services connection layer
 */
@Path("/userInfo")
public class UserInformationIWS {
	
	private UserInformation userInformation;
	private UserRepo userrepo;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/insertUser")
	public Response userInformationPojo (UserDataPojo userData){
		userInformation = new UserInformation();
		userInformation.InsertUserInfo(userData);
		userInformation = new UserInformation();
		int id = userInformation.getUserIdByEmail(userData.getEmail());
		return Response.ok()
				.entity(id)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUser/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response locateUserById (@PathParam("userId") int id){
		userInformation = new UserInformation();
		UserDataPojo userById = userInformation.getUserInfo(id);
		return Response.ok()
				.entity(userById)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/ifEmailExists/{email}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response locateEmail (@PathParam("email") String email){
		userInformation = new UserInformation();
		Boolean value = userInformation.getUserByEmail(email);
		return Response.ok()
				.entity(value)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateUser")
	public Response updateUserInfo (UserDataPojo userData){
		userInformation = new UserInformation();
		userInformation.UpdateUser(userData);
		return Response.status(200).entity("User Updated Successful").build();	
	}

	@GET
	@Path("/validPassword/{email}/{password}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response validateLogin (@PathParam("email") String email, @PathParam("password") String password){
		userInformation = new UserInformation();
		String userId = userInformation.loginValidation(email, password);
		return Response.ok()
				.entity(userId)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getFavList/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFavList (@PathParam("userId") int id){
		userInformation = new UserInformation();
		ResponseBuoyList buoydata = userInformation.getUserFavList(id);
		return Response.ok()
				.entity(buoydata)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
}
