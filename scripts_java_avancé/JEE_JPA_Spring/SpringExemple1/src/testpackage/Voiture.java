package testpackage;

public class Voiture {
	private Roue roue;

	public Roue getRoue() {
		return roue;
	}

	public void setRoue(Roue roue) {
		this.roue = roue;
	}

	public Voiture(Roue roue) {
		this.roue = roue;
		System.out.println("Constructeur par injection");
	}
	public Voiture() {
		System.out.println("Constructeur par défaut");
	}
	
	
}
