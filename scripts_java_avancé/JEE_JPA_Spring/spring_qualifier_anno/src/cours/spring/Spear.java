package cours.spring;

import org.springframework.stereotype.Component;

@Component("lance")
public class Spear implements Object {

	public String use() {
		return "throw spear";
	}

	@Override
	public String toString() {
		return "Spear";
	}


}
