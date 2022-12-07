package com.delhomvi.delhomvi;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin
@RestController
public class PostControlller  
{
	
	private static Livre book;

	private static ArrayList<Livre> listBook = new ArrayList();
	
	@PostMapping( "/createLivre" )
	public ResponseEntity createLivre(@RequestBody Map<String, String> request)
	{
		 System.out.println( request.get("titre") + "   de " + request.get("auteur"));
		 System.out.println( request.get("SESSIONID") );
		 return ResponseEntity.ok( request.get("titre") + "   de " + request.get("auteur") );
		 //return ResponseEntity.ok().build( "gdfghzfghefgh"  );
	}		


    @PostMapping("/addLivre")
    public ResponseEntity  addLivre(@RequestBody Livre livre)
    {
		book = livre; 
		listBook.add( livre );
		System.out.println(livre);
		//return livre.toString();
		//return HttpStatus.OK;
		return ResponseEntity.ok( livre );
    }

    @GetMapping("/getLivrex")
	public Livre getLivre(HttpServletRequest request) 
	{
		return book;
	}
    
    @GetMapping("/getListLivre")
	public ArrayList<Livre> getListLivre(HttpServletRequest request) 
	{
		return listBook;
	}
}










