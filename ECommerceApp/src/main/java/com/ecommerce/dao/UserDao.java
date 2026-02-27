package com.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.model.User;
import com.ecommerce.util.HibernateUtil;



//Used for Saving the New User
public class UserDao {

    public boolean saveUser(User user) {

        Transaction tx = null;

        try (Session session = HibernateUtil
                .getSessionFactory()
                .openSession()) {

            tx = session.beginTransaction();

            session.persist(user);

            tx.commit();

            return true;

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
            return false;
        }
    }
    
 // Checking that whether already user present or Not
    
    public boolean isEmailExists(String email) {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            User user = session.createQuery(
                    "FROM User WHERE email = :email",
                    User.class)
                    .setParameter("email", email)
                    .uniqueResult();

            return user != null;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    
//Used for Validating the User(Used for Login.HTML for Validation)
    
    
    public User validateUser(String email, String password) {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            User user = session.createQuery(
                    "FROM User WHERE email = :email",
                    User.class)
                    .setParameter("email", email)
                    .uniqueResult();

            if (user != null) {
                System.out.println("DB Password: " + user.getPassword());
                
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
 
    
// Used in Forgot user(Password)
    
    public User ForgotUser(String email)
    {
    	Transaction tx = null;
    	try(Session session = HibernateUtil.getSessionFactory().openSession())
    	{
    		User user = session.createQuery("FROM User where email=:email",User.class)
    					.setParameter("email", email)
    					.uniqueResult();
    		
    		return user;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return null;
    }
  
    
    
// Used for Updating the Password    
    

    public void updateUser(String email, String newPassword)
    {
        Transaction tx = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            tx = session.beginTransaction();

            Query query = session.createQuery(
                    "UPDATE User SET password = :password WHERE email = :email");

            query.setParameter("password", newPassword);
            query.setParameter("email", email);

            query.executeUpdate();

            tx.commit();
        }
        catch(Exception e)
        {
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

}
