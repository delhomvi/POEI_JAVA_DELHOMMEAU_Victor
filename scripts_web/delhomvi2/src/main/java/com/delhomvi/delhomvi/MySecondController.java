package com.delhomvi.delhomvi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class MySecondController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/addition")
	public String addition(@RequestParam(value = "arg1", defaultValue = "0") String arg1, @RequestParam(value = "arg2", defaultValue = "0") String arg2) 
	{
		return  String.valueOf(Integer.parseInt( arg1) + Integer.parseInt( arg2));
	}
	
	@GetMapping("/livre")
	public Livre livre(HttpServletRequest request) 
	{
		Livre l = new Livre( "mes mémoires", "toto"); 
		return  l;
	}
}