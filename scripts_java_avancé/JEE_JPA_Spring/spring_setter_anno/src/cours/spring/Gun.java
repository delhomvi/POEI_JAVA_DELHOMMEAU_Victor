package cours.spring;

import org.springframework.stereotype.Component;

@Component
public class Gun {

	public String use() {
		return "Pan Pan";
	}

	public String toString() {
		return "Gun";
	}
}
