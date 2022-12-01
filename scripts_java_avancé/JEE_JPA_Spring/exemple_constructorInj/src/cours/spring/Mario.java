package cours.spring;

public class Mario{

	private Sabre obj;

	Mario()
	{
		System.out.println("Mario :Constructeur par defaut");
	}
	
	Mario(Sabre obj)
	{
		System.out.println("Mario :Constructeur par injection");
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
