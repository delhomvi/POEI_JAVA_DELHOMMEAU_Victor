package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil{
	// Objet session factory
	private static final SessionFactory sessionfactory = buildsessionfactory();
	
	// builder
	private static  SessionFactory buildsessionfactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		}catch(Exception e){
			System.out.print(e.getMessage());
			throw new ExceptionInInitializerError(e);		}
		
	}
	
	// Getter
	public static SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	
	
	
	
}