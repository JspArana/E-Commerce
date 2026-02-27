package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.model.Buy;
import com.ecommerce.util.HibernateUtil;

public class BuyDao {

	public void saveBuy(Buy buy)
	{
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			tx=session.beginTransaction();
			session.persist(buy);
			tx.commit();
		}
			catch(Exception e)
			{
			    e.printStackTrace();
			    if(tx != null) {
			        tx.rollback();
			    }
			}
		}
	
	public List<Buy> getDetails() {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	        return session.createQuery(
	            "SELECT b FROM Buy b JOIN FETCH b.product",
	            Buy.class).list();
	    }
	}
	
	
	
}
