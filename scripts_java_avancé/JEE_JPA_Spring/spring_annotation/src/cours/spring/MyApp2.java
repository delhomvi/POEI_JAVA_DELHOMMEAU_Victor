package cours.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp2 {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		Bowser bowser = context.getBean("bowser", Bowser.class);
		Mario mario = context.getBean("mario", Mario.class);

				
		System.out.println(bowser);
		System.out.println(mario);
		context.close();
	}

}
