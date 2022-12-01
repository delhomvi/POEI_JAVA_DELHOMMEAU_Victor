package entity;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(value="bean")
public class bean {
	private String nom;
	private String prenom;
	private String sexe;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
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
	
	bean(){
		
	}
}
