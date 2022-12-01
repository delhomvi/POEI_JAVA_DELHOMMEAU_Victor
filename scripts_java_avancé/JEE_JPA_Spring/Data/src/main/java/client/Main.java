package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.User;
import util.HibernateUtil;

public class Main {
	public static void addPerso(User pers) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction trx = session.beginTransaction();
		try {
			session.save(pers);
			trx.commit();
		} catch (Exception e) {
			trx.rollback();
		}
		session.close();
	}
	public static void main(String[] args) {
		addPerso(new User("Paul","Pogba",50));
		addPerso(new User("Didier","Deschamps",50));
		addPerso(new User("Zidane","Zinedine",50));
		addPerso(new User("Olivier","Giroud",50));
		addPerso(new User("Lionel","Messi",50));
	}
}
