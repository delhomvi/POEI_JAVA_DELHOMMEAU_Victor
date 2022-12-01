package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Tasse;
import util.HibernateUtil;

public class Main {
	public static void addToDB(Tasse mug) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction trx = session.beginTransaction();
		try {
			session.persist(mug);
			trx.commit();
		} catch (Exception e) {
			trx.rollback();
		}
		session.close();
	}

	public static Tasse getTasse(int id) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction trx = session.beginTransaction();
		Tasse ret = null;
		try {
			ret = session.get(Tasse.class, id);
			trx.commit();
		} catch (Exception e) {
			trx.rollback();
		}
		session.close();
		return ret;
	}

	public static void updateTasse(Tasse a) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction txn = session.beginTransaction();
		try {
			session.update(a);
			txn.commit();
		} catch (Exception e) {
			txn.rollback();
		}
		session.close();
	}
	
	public static void deleteTasse(Tasse a) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction txn = session.beginTransaction();
		try {
			session.delete(a);
			txn.commit();
		} catch (Exception e) {
			txn.rollback();
		}
		session.close();
	}
	
	public static void saveOrUpdateTasse(Tasse a) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction txn = session.beginTransaction();
		try {
			session.saveOrUpdate(a);
			txn.commit();
		} catch (Exception e) {
			txn.rollback();
		}
		session.close();
	}
	
	public static void main(String[] args) {
		Tasse mug = new Tasse(false, true, "<3 mum", "chouchou");
		addToDB(mug);
		//mug.setGravure("toto");
		//updateTasse(mug);
		//deleteTasse(mug);
	}
}
