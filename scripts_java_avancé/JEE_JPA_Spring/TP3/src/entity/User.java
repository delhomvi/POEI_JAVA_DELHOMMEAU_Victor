package entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "User")
@SessionScoped
public class User {
	private String nom;
	private String prenom;
	private String sexe;
	private int page;

	// Constructeurs
	public User() {
	}

	public User(String nom) {
		this.nom = nom;
	}

	// Getters et seters
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "User [nom=" + nom + "]";
	}

	// Autres fonctions
	public Boolean isWhatM() {
		if (sexe.equals("Homme")) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isWhatF() {
		if (sexe.equals("Femme")) {
			return true;
		} else {
			return false;
		}
	}
	
public int nextPage() {
	if(page>=1) {this.page=0;return 0;}
	else {this.page++; return this.page;}
}
}
