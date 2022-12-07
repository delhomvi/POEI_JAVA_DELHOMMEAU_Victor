package com.delhomvictor.tpOne.delhomvictor;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Ticket {
	static Integer counter = 0;
	String clientName = "undefined";
	ArrayList<Article> articles = new ArrayList<>();
	Integer totalPrice = 0;

	public Ticket(String clientName) {
		this.clientName = clientName;
		generateID();
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Ticket [clientName=" + clientName + ", articles=" + articles + ", totalPrice=" + totalPrice + "]";
	}

	public void addArticle(String nom, Integer price) {
		articles.add(new Article(nom, price));
	}

	public String allArticleToString() {
		String res = "";
		for(Article article : articles) {
			res+=String.format("Article : %s Prix : %s | ", article.getItem(),article.getPrix());
		}
		return res;
	}
	
	public void generateID() {
		counter+=1;
	}
}
