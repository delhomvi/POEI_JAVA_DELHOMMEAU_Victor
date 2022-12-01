package cours.spring;

import org.springframework.stereotype.Component;

@Component("mario")
public class Mario{

	private Sabre obj;
	private String name;

	Mario()
	{
		System.out.println("mario Constructeur par defaut");
	}
	
	Mario(Sabre obj)
	{
		this.obj = obj;
		System.out.println(name +  " :Constructeur par injection");
	}
	
	public Mario(Sabre obj, String name) {
		this.obj = obj;
		this.name = name;
		System.out.println(name +  " :Constructeur par injection");
	}

	public Sabre getObj() {
		return obj;
	}

	public void setObj(Sabre obj) {
		this.obj = obj;
		System.out.println(name +  " :setter obj par injection");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(name +  " :setter name par injection");
	}

	public String utilisationObject()
	{
		return obj.use();
	}

	public String attaque() {
		return "name + fait des sauts";
	}

	@Override
	public String toString() {
		return "Mario [obj=" + obj + ", name=" + name + "]";
	}
}
