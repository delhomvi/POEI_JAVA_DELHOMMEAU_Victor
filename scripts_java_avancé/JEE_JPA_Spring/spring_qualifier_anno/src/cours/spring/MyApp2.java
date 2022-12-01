package cours.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		Perso player1 = context.getBean("bowser", Perso.class);
		Perso player2 = context.getBean("mario", Perso.class);		
		
		System.out.println(player1.attaque());
		System.out.println(player1.utilisationObject());
		System.out.println(player2.attaque());
		System.out.println(player2.utilisationObject());
		context.close();
	}

}
