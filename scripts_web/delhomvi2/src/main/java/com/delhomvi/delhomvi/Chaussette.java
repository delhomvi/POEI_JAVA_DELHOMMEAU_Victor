package com.delhomvi.delhomvi;

public class Chaussette {
	private String couleur;
	private String matiere;
	private int co2;
	
	public Chaussette(String couleur, String matiere, int co2) {
		this.couleur = couleur;
		this.matiere = matiere;
		this.co2 = co2;
	}
	
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public int getCo2() {
		return co2;
	}
	public void setCo2(int co2) {
		this.co2 = co2;
	}
	

}
