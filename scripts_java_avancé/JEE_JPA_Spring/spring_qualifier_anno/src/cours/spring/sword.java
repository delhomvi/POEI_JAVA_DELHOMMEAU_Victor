package cours.spring;

import org.springframework.stereotype.Component;

@Component
public class sword implements Object {

	public String use() {
		return "Swing swing";
	}

	@Override
	public String toString() {
		return "Sword";
	}


}
