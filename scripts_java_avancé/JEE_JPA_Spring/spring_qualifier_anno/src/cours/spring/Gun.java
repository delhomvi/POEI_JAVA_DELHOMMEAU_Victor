package cours.spring;

import org.springframework.stereotype.Component;

@Component
public class Gun implements Object {

	public String use() {
		return "Pan Pan";
	}

	@Override
	public String toString() {
		return "Gun";
	}


}
