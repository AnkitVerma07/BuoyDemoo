package com.demo.buoys.BuoysDemoo.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.buoys.BuoysDemoo.db.entity.Buoy;
import com.demo.buoys.BuoysDemoo.db.entity.User;

public class BuoyRepo {
	//note: need to create only one session factory for entire project. 
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	public void InsertBuoyData(Buoy buoyData){
				session.beginTransaction();
				session.save(buoyData);
				session.getTransaction().commit();
				session.close();
				session.getSessionFactory().close();
			   }
	
	public void InsertFavBuoyData(Buoy buoyData, User userdata){
		session.beginTransaction();
		session.merge(buoyData);
		session.merge(userdata);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }

	public void updateBuoydata(Buoy buoyData){
		session.beginTransaction();
		session.merge(buoyData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public List<Buoy> getBuoyDataByStationId(String stationId){
		session.beginTransaction();
		Query query = session.createQuery("from Buoy where station_id='"+ stationId +"'");
		List<Buoy> buoyData = (List<Buoy>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return buoyData;
	}
	
	public Buoy getBuoyData(int id){
		Buoy buoydata = new Buoy();
		session = sessionFactory.openSession();
		session.beginTransaction();
		buoydata = (Buoy)session.get(Buoy.class, id);
		session.close();
		session.getSessionFactory().close();
		return buoydata;
}
	
	public List<Buoy> getBuoyList(){
		session.beginTransaction();
		Query query = session.createQuery("from Buoy");
		List<Buoy> buoyData = (List<Buoy>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return buoyData;
	}
}
