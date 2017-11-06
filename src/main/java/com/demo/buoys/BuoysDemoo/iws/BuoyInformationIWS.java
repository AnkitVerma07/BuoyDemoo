package com.demo.buoys.BuoysDemoo.iws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.demo.buoys.BuoysDemoo.db.entity.Buoy;
import com.demo.buoys.BuoysDemoo.db.entity.User;
import com.demo.buoys.BuoysDemoo.information.BuoyInformation;
import com.demo.buoys.BuoysDemoo.information.UserInformation;
import com.demo.buoys.BuoysDemoo.pojo.iws.BuoyDataPojo;
import com.demo.buoys.BuoysDemoo.pojo.iws.BuoySearchDataPojo;
import com.demo.buoys.BuoysDemoo.pojo.iws.ResponseBuoyList;
import com.demo.buoys.BuoysDemoo.pojo.iws.UserCredentials;
import com.demo.buoys.BuoysDemoo.pojo.iws.UserDataPojo;

/**
 * @author Ankit_Verma
 * 
 */
@Path("/buoyInfo")
public class BuoyInformationIWS {
	
	private BuoyInformation buoyInfo;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertBuoy")
	public Response buoyInformationPojo (BuoyDataPojo buoyData){
		buoyInfo = new BuoyInformation();
		buoyInfo.InsertBuoyInfo(buoyData);
		return Response.status(200).entity("Buoy successfully Added").build();
	}
	
	@GET
	@Path("/insertFavBuoy/{userId}/{buoyId}")
	public Response buoyFavPojo (@PathParam("userId") int userId, @PathParam("buoyId") int buoyId){
		buoyInfo = new BuoyInformation();
		buoyInfo.InsertFavBuoyInfo(userId, buoyId);
		return Response.status(200).entity("Favorite successfully Added").build();
	}
	
	
	
	@GET
	@Path("/getBuoy/{stationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response locateBuoyByStationId (@PathParam("stationId") String id){
		buoyInfo = new BuoyInformation();
		BuoyDataPojo buoydata = buoyInfo.getBuoyInfo(id);
		return Response.ok()
				.entity(buoydata)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getBuoyInfo/{buoyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response locateBuoy (@PathParam("buoyId") int id){
		buoyInfo = new BuoyInformation();
		BuoyDataPojo buoydata = buoyInfo.getBuoy(id);
		return Response.ok()
				.entity(buoydata)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getBuoyList/{lon}/{lat}/{radius}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBuoyList (@PathParam("lon") String lon, @PathParam("lat") String lat, @PathParam("radius") int radius){
		buoyInfo = new BuoyInformation();
		ResponseBuoyList buoydata = buoyInfo.getBuoyList(lon,lat,radius);
		return Response.ok()
				.entity(buoydata)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	




}
