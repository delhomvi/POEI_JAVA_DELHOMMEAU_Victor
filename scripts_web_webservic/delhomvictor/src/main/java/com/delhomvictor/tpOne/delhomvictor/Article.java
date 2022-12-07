package com.delhomvictor.tpOne.delhomvictor;


public class Article {
	String item;
	Integer prix;

	public Article(String item, Integer prix) {

		this.item = item;
		this.prix = prix;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Article [item=" + item + ", prix=" + prix + "]";
	}



}
