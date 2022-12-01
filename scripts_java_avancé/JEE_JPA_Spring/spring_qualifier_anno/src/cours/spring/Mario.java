package cours.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Mario implements Perso {
	@Autowired
	@Qualifier("lance")
	private Object obj;

	Mario()
	{
		System.out.println("Mario :Constructeur par default");
	}
	
	Mario(Object obj)
	{
		System.out.println("Mario :Constructeur par injection "+ obj);
		this.obj = obj;
	}
	
	public void setObj(Object obj)
	{
		System.out.println("Mario :Setter par injection " + obj);
		this.obj = obj;
	}
	
	public String utilisationObject()
	{
		return obj.use();
	}

	public String attaque() {
		return "Mario fait des sauts";
	}
	

}
