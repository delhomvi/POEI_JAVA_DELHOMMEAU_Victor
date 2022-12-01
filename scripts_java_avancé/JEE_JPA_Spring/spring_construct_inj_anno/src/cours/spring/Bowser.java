package cours.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bowser {
	
	private Gun obj;
	private String name;
	
	
	public Bowser()
	{
		System.out.println("Bowser :Constructeur par defaut");
	}

	@Autowired
	public Bowser(Gun obj) {
		this.obj = obj;
		System.out.println(name + " :Constructeur par injection obj");
	}

	public Bowser(Gun gun, String name)
	{
		this.obj = gun;
		this.name = name;
		System.out.println(name + " :Constructeur par injection " + gun + name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(name + " :setter par injection " + name);
	}
	
	public Gun getObj() {
		return obj;
	}


	public void setObj(Gun obj) {

		this.obj = obj;
		System.out.println(name + " :setter par injection " + obj);
	}

	@Override
	public String toString() {
		return "Bowser [obj=" + obj + ", name=" + name + "]";
	}

	public String utilisationObject()
	{
		return obj.use();
	}
	
	public String attaque() {
		return "Bowser crache des flammes";
	}

}
