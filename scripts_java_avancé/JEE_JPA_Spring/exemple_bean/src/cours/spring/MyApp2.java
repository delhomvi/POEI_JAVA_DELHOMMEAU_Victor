package cours.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf.xml");
		
		
		Bowser player1 = context.getBean("bowser", Bowser.class);
		Mario b1 = context.getBean("x", Mario.class);
		Mario player2 = context.getBean("mario", Mario.class);
		
		System.out.println(b1.attaque());
		System.out.println(player1.attaque());
		System.out.println(player2.attaque());
		context.close();
	}

}
