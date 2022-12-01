package cours.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp2 {
	
	public static void fonction(ClassPathXmlApplicationContext context)
	{
		System.out.println('\n');
		Bowser bowser = context.getBean("bowser", Bowser.class);
		Mario mario = context.getBean("mario", Mario.class);
		Mario luigi = context.getBean("luigi", Mario.class);
		System.out.println('\n');


		
		System.out.println(bowser);
		System.out.println(mario);
		System.out.println(luigi);
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		Bowser bowser = context.getBean("bowser", Bowser.class);
		Mario mario = context.getBean("mario", Mario.class);
		Mario luigi = context.getBean("luigi", Mario.class);

		
		
		fonction(context);
		
		System.out.println(bowser);
		System.out.println(mario);
		System.out.println(luigi);
		context.close();
	}

}
