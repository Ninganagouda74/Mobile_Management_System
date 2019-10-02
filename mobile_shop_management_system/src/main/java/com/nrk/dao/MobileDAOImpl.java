package com.nrk.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nrk.model.Mobile;

public class MobileDAOImpl implements MobileDAO {
	
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getsession()
    {
    	return sessionFactory;
    }
	
	public void save(Mobile p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}
	
	public Mobile getName(String name)
	{
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Mobile where name = :id");
		query.setString("id",name);
		Mobile p = (Mobile) query.uniqueResult();
		return p;
		
	}
	
	public Mobile getImage(String name)
	{
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Mobile where name = :id");
		query.setString("id",name);
		Mobile p = (Mobile) query.uniqueResult();
		return p;
		
	}
	
	
	
	public int delete(String name)
	{
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("delete from Mobile where name = :id");
		query.setString("id",name);
		int result = query.executeUpdate();
		//System.out.println("Employee Delete Status="+result);
		session.close();
		return result;
	}
	
	public void search(String name)
	{
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from mobile where name= :id");
	}
	
	@SuppressWarnings("unchecked")
	public List<Mobile> list() {
		Session session = this.sessionFactory.openSession();
		List<Mobile> MobileList = session.createQuery("from Mobile").list();
		session.close();
		return MobileList;
	}

}


