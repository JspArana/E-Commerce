package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.model.Product;
import com.ecommerce.util.HibernateUtil;

public class ProductDao {

	//Used this for Getting all the Product Details
	 public List<Product> getAllProducts() {

	        try (Session session =
	                HibernateUtil.getSessionFactory().openSession()) {

	            return session.createQuery("FROM Product",
	                    Product.class).list();
	        }
	    }
	 
	// Used this for Saving the Product 
	 public void saveProduct(Product product)
	 {
		 Transaction tx = null;
		 
		 try(Session session = HibernateUtil.getSessionFactory().openSession())
		 {
			 tx = session.beginTransaction();
			 session.persist(product);
			 tx.commit();
		 }
		 catch(Exception e)
		 {
			 if(tx!=null)
			 {
				tx.rollback();
			 }
		 }
	 }
	 
	 
	 // Getting the Single product Details for Buying that Product
	 
	public Product getProductById(int id)
	{
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			 tx = session.beginTransaction();
			return session.get(Product.class,id);
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
		}
		return null;
	}
	 
	
}
