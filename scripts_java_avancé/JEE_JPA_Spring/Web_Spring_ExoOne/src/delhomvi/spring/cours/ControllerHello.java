package delhomvi.spring.cours;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerHello {
	// Methode qui va nous renvoyer l'url de notre view
	// WEB-INF/view/index.jsp

	@RequestMapping("/") // Au lancement du serveur, il y aura juste / de renvoyé
	public String getMenu() {
		return "index";  // <- WEB-INF/view/index.jsp
	}
	
	@RequestMapping("/index")
	public String getMain() {
		return "index";
	}
	
	@RequestMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@RequestMapping("/formulaire")
	public String getFormulaire() {
		return "formulaire";
	}
	
	@RequestMapping("/resultats")
	public String getResultats(HttpServletRequest request,Model model) {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String age = request.getParameter("age");
		String email = String.format("%s.%s.%s@gmail.com",nom,prenom,age);
		model.addAttribute("email",email);
		return "resultats";
	}
	


	public String getexoMPD() {
		return "exoMPD";
	}
	
	@RequestMapping("/RESexoMPD")
	public String getRESexoMPD(HttpServletRequest request,Model model) {
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		if(user.equals("user") & pass.equals("password")) {
			return "RESexoMPD";
		}
		else {
			return "exoMPD";
		}
	}
}
