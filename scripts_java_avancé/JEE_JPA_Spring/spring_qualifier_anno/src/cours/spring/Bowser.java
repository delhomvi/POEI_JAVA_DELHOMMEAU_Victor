package cours.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component()
public class Bowser implements Perso {
	
	@Autowired
	@Qualifier("gun")
	private Object obj;

	Bowser()
	{
		System.out.println("Bowser :Constructeur par defaut ");
	}

	Bowser(Object obj)
	{
		System.out.println("Bowser :Constructeur par injection " + obj);
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
		return "Bowser crache des flammes";
	}

}
