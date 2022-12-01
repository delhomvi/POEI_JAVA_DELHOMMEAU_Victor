package cours.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bowser {
	
	private Gun obj;

	Bowser()
	{
		System.out.println("Bowser :Constructeur par defaut ");
	}

	Bowser(Gun obj)
	{
		System.out.println("Bowser :Constructeur par injection " + obj);
		this.obj = obj;
	}
	
	@Autowired
	public void setObj(Gun obj)
	{
		this.obj = obj;
		System.out.println("Bowser :Setter par injection " + obj);
	}
	
	public String utilisationObject()
	{
		return obj.use();
	}
	
	public String attaque() {
		return "Bowser crache des flammes";
	}

}
