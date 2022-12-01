package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="titre")
	private String title;
	@Column(name="auteur")
	private String author;
	@Column(name="dateDePublication")
	private String dateOfPublication;
	@Column(name="Prix")
	private String price;
	
	// Constructeurs
	public Book(String title, String author, String dateOfPublication, String price) {
		this.title = title;
		this.author = author;
		this.dateOfPublication = dateOfPublication;
		this.price = price;
	}
	
	public Book() {
	}
	
	// Get/Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	// toString
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", dateOfPublication=" + dateOfPublication
				+ ", price=" + price + "]";
	}
	
	
	

}
