package com.mycompany.phonebook.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Michael Kupryk on 14.06.2017.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            //Create session with hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure();
            SessionFactory sf = new Configuration().configure().buildSessionFactory();
            return sf;
        } catch (Throwable ex){
            System.err.println("Initial SessionFactory failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutDown(){
        //Clear the cache and close db connection
        getSessionFactory().close();
    }
}
