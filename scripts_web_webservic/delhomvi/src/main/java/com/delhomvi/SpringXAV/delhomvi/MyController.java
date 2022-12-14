package com.delhomvi.SpringXAV.delhomvi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MyController {
	
	@CrossOrigin
	@GetMapping("/testAPI")
	public String testAPI(HttpServletRequest request, Model model) {
		return "testAPI";
	}
	
	@CrossOrigin
	@GetMapping("/toto")
	public String testtoto(HttpServletRequest request, Model model) {
		return "toto";
	}

}
