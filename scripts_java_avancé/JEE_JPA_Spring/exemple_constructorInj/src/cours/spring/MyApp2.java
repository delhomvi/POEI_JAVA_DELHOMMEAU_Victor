package cours.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		Bowser player1 = context.getBean("bowser", Bowser.class);
		Mario player2 = context.getBean("mario", Mario.class);
		
		System.out.println(player1.attaque());
		System.out.println(player1.utilisationObject());
		System.out.println(player2.attaque());
		System.out.println(player2.utilisationObject());
		context.close();
	}

}
