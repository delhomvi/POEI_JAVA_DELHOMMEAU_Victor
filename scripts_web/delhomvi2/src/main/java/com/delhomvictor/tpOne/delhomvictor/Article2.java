package com.delhomvictor.tpOne.delhomvictor;


public class Article2 {
	String item;
	Integer prix;
	long ID;

	public Article2(String item, Integer prix, long iD) {
		super();
		this.item = item;
		this.prix = prix;
		this.ID=iD;
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

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

}
