package client;

public class modifLivres {
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
	public modifLivres(String title, String author, String dateOfPublication, String price) {
		this.title = title;
		this.author = author;
		this.dateOfPublication = dateOfPublication;
		this.price = price;
	}
	
	public modifLivres() {
	}
}
