package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Book;
import util.HibernateUtil;

public class Main {
	
	// Constructeur
	public static void main(String[] args) {
	}
	
	// Contact avec la BDD
	public static void addToDB(Book livre) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction trx = session.beginTransaction();
		try {
			session.persist(livre);
			trx.commit();
		} catch (Exception e) {
			trx.rollback();
		}
		session.close();
	}

	public static Book getOnDDB(int id) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction trx = session.beginTransaction();
		Book ret = null;
		try {
			ret = session.get(Book.class, id);
			trx.commit();
		} catch (Exception e) {
			trx.rollback();
		}
		session.close();
		return ret;
	}

	public static void updateDDB(Book a) {
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
	
	public static void deleteOnDDB(Book a) {
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
	
	// Autres fonctions
	public static void showAllBooks() {
		
	}
}
