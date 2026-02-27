package com.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.model.Admin;
import com.ecommerce.model.Product;
import com.ecommerce.util.HibernateUtil;
import com.mysql.cj.Query;

public class AdminDao {

	
	public Admin ValidateAdmin(String email, String password) {

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    String hql = "FROM Admin WHERE email = :email AND password = :password";

	    Admin admin = session.createQuery(hql, Admin.class)
	                         .setParameter("email", email)
	                         .setParameter("password", password)
	                         .uniqueResult();

	    session.close();

	    return admin;
	}

	public boolean editProduct(int id, String name, String description, double price)
	{
		Transaction tx = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			tx = session.beginTransaction();
			
			Product prod =session.get(Product.class, id);
			
			if (prod != null)
	        {
	            prod.setName(name);
	            prod.setDescription(description);
	            prod.setPrice(price);

	            session.update(prod);
	            tx.commit();
	            return true;
	        }

	    }
	    catch (Exception e)
	    {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    }

	    return false;
	
	}
	
	public boolean deleteProduct(int id)
	{
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			tx=session.beginTransaction();
			
			Product product = session.get(Product.class, id);
			
			if(product != null)
			{
				session.remove(product);
				tx.commit();
				return true;
			}
		}
		catch(Exception e)
		{
			if (tx != null) tx.rollback();
	        e.printStackTrace();		
	    }
		return false;
	}
}
