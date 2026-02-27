package com.ecommerce.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ecommerce.model.Admin;
import com.ecommerce.model.Buy;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();

            // Load hibernate.cfg.xml
            configuration.configure();

            // 🔥 VERY IMPORTANT - Register Entity Class
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Admin.class);
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(Cart.class);
            configuration.addAnnotatedClass(Buy.class);

            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
