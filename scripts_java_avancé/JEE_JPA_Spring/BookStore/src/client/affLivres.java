package client;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;

import entity.Book;
import util.HibernateUtil;

public class affLivres {
	private String title;
	private String author;
	private String dateOfPublication;
	private String price;
	
	// GettersSetters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDateOfPublication() {
		return dateOfPublication;
	}
	public void setDateOfPublication(String dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	// Constructeurs
	public affLivres(String title, String author, String dateOfPublication, String price) {
		this.title = title;
		this.author = author;
		this.dateOfPublication = dateOfPublication;
		this.price = price;
	}
	
	public affLivres() {
	}
	
	public void showAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction trx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select emp_id, emp_name, emp_salary from Employee");
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			Book book = new Book();
			book.setId(Integer.parseInt(row[0].toString()));
			book.setTitle(row[1].toString());
			book.setAuthor(row[2].toString());
			book.setDateOfPublication(row[3].toString());
			book.setPrice(row[4].toString());
			System.out.println(book);
		}
	}
}
