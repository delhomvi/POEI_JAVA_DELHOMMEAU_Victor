package cours.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mario {

	private Gun obj;

	Mario()
	{
		System.out.println("Mario :Constructeur par default");
	}
	
	Mario(Gun obj)
	{
		System.out.println("Mario :Constructeur par injection "+ obj);
		this.obj = obj;
	}
	
	@Autowired
	public void setObj(Gun obj)
	{
		this.obj = obj;
		System.out.println("Mario :Setter par injection " + obj);
	}
	
	public String utilisationObject()
	{
		return obj.use();
	}

	public String attaque() {
		return "Mario fait des sauts";
	}
	

}
