package com.delhomvi.delhomvi;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin
@RestController
public class PostController {	
	@PostMapping("/createLivre")
	public ResponseEntity getLivre(@RequestBody Map<String, String> request) {
		System.out.println(request.get("titre") + " de " + request.get("auteur"));
		return ResponseEntity.ok(request.get("titre") + " de " + request.get("auteur"));
	}

	@PostMapping("/addLivre")
	public String addLivre(@RequestBody Livre livre) {
		System.out.println(livre);
		return livre.toString();
	}
	
}