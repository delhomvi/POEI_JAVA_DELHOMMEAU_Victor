package cours.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Player {
	@Autowired
	@Qualifier("bowser")
	private Perso perso;

	public Player() {
		System.out.println("Player :Constructeur par default");
	}
	
	public Player(Perso perso) {
		this.perso = perso;
		System.out.println("Player :Constructeur par injection");
	}

	public Perso getPerso() {
		return perso;
	}

	public void setPerso(Perso perso) {
		this.perso = perso;
		System.out.println("Player :setter par injection");
	}
}
