package com.demo.buoys.BuoysDemoo.repository;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.buoys.BuoysDemoo.db.entity.User;

import java.util.List;


/**
 * @author Ankit_Verma
 * get the user data object from service and store to DB using hibernate
 */
public class UserRepo {
	//note: need to create only one session factory for entire project. 
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	public void InsertUserData(User userData){
				session.beginTransaction();
				session.save(userData);
				session.getTransaction().commit();
				session.close();
				session.getSessionFactory().close();
			   }

	public void updateUserdata(User userData){
		session.beginTransaction();
		session.merge(userData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public User getUserData(int userID){
				User userData = new User();
				session = sessionFactory.openSession();
				session.beginTransaction();
				userData = (User)session.get(User.class, userID);
				session.close();
				session.getSessionFactory().close();
				return userData;
	}
	
	public List<User> LocateUserByEmail(String email){
		session.beginTransaction();
		Query query = session.createQuery("from User where email='"+ email +"'");
		List<User> userData = (List<User>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return userData;
	}
	
}
