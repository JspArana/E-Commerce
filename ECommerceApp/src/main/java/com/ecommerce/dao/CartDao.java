package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.util.HibernateUtil;

public class CartDao {
	
	public List<Cart> getAllCart()
	{
		
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			return session.createQuery("FROM Cart", Cart.class).list();		
		
		}

	}
	
	public void addToCart(int productId) {

	    Transaction tx = null;

	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {

	        tx = session.beginTransaction();

	        Product product = session.get(Product.class, productId);

	        Cart cart = new Cart();
	        cart.setProduct(product);

	        session.save(cart);

	        tx.commit();
	    }
	}
	
	public void deleteCart(int cartId) {

	    Transaction tx = null;

	    try (Session session = HibernateUtil
	            .getSessionFactory()
	            .openSession()) {

	        tx = session.beginTransaction();  

	        Cart cart = session.get(Cart.class, cartId);

	        if (cart != null) {
	            session.remove(cart);
	            System.out.println("Cart item deleted successfully!");
	        } else {
	            System.out.println("Cart item not found!");
	        }

	        tx.commit();   

	    } catch (Exception e) {

	        if (tx != null) {
	            tx.rollback();   
	        }

	        e.printStackTrace();
	    }
	}

}
