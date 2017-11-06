package com.demo.buoys.BuoysDemoo.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.demo.buoys.BuoysDemoo.db.entity.Buoy;
import com.demo.buoys.BuoysDemoo.information.BuoyInformation;
import com.demo.buoys.BuoysDemoo.pojo.iws.BuoyDataPojo;
import com.demo.buoys.BuoysDemoo.repository.BuoyRepo;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;


public class FeedReader {

	private BuoyDataPojo buoydata;
	private BuoyInformation buoyInfo;
	private Buoy buoyEntity;
	private BuoyRepo buoyrepo;
	
    public List<BuoyDataPojo> insertParseFeed(String url) {
    	buoydata = new BuoyDataPojo();
    	List<Buoy> buoyList = new ArrayList<Buoy>();
    	List<BuoyDataPojo> returnList = new ArrayList<BuoyDataPojo>();
        boolean ok = false;
            try {
                URL feedUrl = new URL(url);
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(feedUrl));
                List entries = feed.getEntries();
        		Iterator itEntries = entries.iterator(); 
        		while (itEntries.hasNext()) {
        			SyndEntry entry = (SyndEntry) itEntries.next();
        			String station = entry.getTitle();
        			String[] splitSpace = station.split("\\s+");
        			buoydata.setStation_id(splitSpace[1]);
        			buoydata.setStation_location(station.substring(station.indexOf(splitSpace[3])));
        			String descriptionData = entry.getDescription().getValue();
        			String lines[] = descriptionData.split("\\r?\\n");
    				String date = lines[1].substring(lines[1].indexOf("<strong>")+8, lines[1].indexOf("</strong>"));
        			buoydata.setDate(date);
        			for(int i = 2; i < lines.length-1; i++){
        				String header = lines[i].substring(lines[i].indexOf("<strong>")+8, lines[i].indexOf(":</strong"));
            			String value = lines[i].substring(lines[i].indexOf("</strong>")+10, lines[i].indexOf("<br />"));
            			if(header.equals("Location")){
            				buoydata.setLocation(value);
            			} else if (header.equals("Wind Direction")){
            				buoydata.setWindDirection(value);
            			} else if (header.equals("Wind Speed")){
            				buoydata.setWindSpeed(value);
            			} else if (header.equals("Wind Gust")){
            				buoydata.setWindGust(value);
            			} else if (header.equals("Significant Wave Height")){
            				buoydata.setSignificantWaveHeight(value);
            			} else if (header.equals("Dominant Wave Period")){
            				buoydata.setDominantWavePeriod(value);
            			} else if (header.equals("Average Period")){
            				buoydata.setAveragePeriod(value);
            			} else if (header.equals("Mean Wave Direction")){
            				buoydata.setMeanWaveDirection(value);
            			} else if (header.equals("Atmosphere Pressure")){
            				buoydata.setAtmospherePressure(value);
            			} else if (header.equals("Pressure Tendency")){
            				buoydata.setPressureTendency(value);
            			} else if (header.equals("Air Temperature")){
            				buoydata.setAirTemperature(value);
            			} else if (header.equals("Dew Point")){
            				buoydata.setDewPoint(value);
            			} else if (header.endsWith("Water Temperature")){
            				buoydata.setWaterTemperature(value);
            			}
        			}
        			buoyInfo = new BuoyInformation();
        			buoyInfo.InsertBuoyInfo(buoydata);
        			buoyrepo = new BuoyRepo();
        			buoyList = buoyrepo.getBuoyList(); 
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
        			
        			
        		}
        		
                ok = true;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("ERROR: "+ex.getMessage());
            }

        if (!ok) {
            System.out.println();
            System.out.println("FeedReader reads and prints any RSS/Atom feed type.");
            System.out.println("The first parameter must be the URL of the feed to read.");
            System.out.println();
        }
        return returnList;
    }

}
