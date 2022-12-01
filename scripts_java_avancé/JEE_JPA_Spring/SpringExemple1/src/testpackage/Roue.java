package testpackage;

public class Roue {
	private int taille;
	private String marque;
	@Override
	public String toString() {
		return "Roue [taille=" + taille + ", marque=" + marque + "]";
	}
	public Roue(int taille, String marque) {
		this.taille = taille;
		this.marque = marque;
	}
	
	public Roue() {
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	
	
}
