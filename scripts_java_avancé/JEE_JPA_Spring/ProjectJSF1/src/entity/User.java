package entity;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(value="User")
public class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
