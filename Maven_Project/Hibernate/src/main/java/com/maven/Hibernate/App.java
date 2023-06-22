package com.maven.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure("hibernate.cfg.xml");
    	
    	SessionFactory sf = con.buildSessionFactory();
    	
    	UserDetails ud = new UserDetails();
    	
    	ud.setName("Ronak");
    	ud.setEmail("ronak@gmail.com");
    	ud.setPassword("Ronak@123");
    
    	Session s = sf.openSession();
    	Transaction tx = s.beginTransaction();
    	s.delete(ud);
    	
    	tx.commit();
    }
}
