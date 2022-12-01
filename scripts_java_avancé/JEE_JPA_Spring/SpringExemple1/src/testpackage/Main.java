package testpackage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// Utilisation du fichier xml et definition des beans
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf.xml");
		Voiture v1 = context.getBean("Nissan",Voiture.class);
		System.out.println(v1.getRoue().getMarque());
		context.close();
	}

}
