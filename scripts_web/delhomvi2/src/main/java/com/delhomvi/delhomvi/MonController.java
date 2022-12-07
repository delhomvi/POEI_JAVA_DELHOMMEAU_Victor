package com.delhomvi.delhomvi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MonController {
	

	@GetMapping( "/toto"  )
	public String bonjour( HttpServletRequest request )
	{
		return "<h1>bonjour Toto</h1>";
	}

	@GetMapping( "/chaussette"  )
	public Chaussette chaussette( HttpServletRequest request )
	{
		Chaussette chaus = new Chaussette( "noel", "laine", 45 );
		return chaus;
	}
}
