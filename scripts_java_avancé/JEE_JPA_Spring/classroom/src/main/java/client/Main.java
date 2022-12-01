package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Personne;
import util.HibernateUtil;

public class Main {
	public static void addPerso(Personne pers) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction trx = session.beginTransaction();
		try {
			session.save(pers);
			trx.commit();
		} catch (Exception e) {
			trx.rollback();
		}
	}
	public static void main(String[] args) {
		addPerso(new Personne("Marley", "Bob",15));

		addPerso(new Personne("Dylan", "Bob",14));
		
		addPerso(new Personne("Leponge", "Bob",18));

		addPerso(new Personne("Lebricoleur", "Bob",17));

		addPerso(new Personne("Lenon", "Bob",48));

		addPerso(new Personne("Bobbybob", "Bob",78));

		addPerso(new Personne("Ross", "Bob",98));
	}
}
