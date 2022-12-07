package com.delhomvictor.tpOne.delhomvictor;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

//import org.json.XML;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {
	ArrayList<Ticket> tickets = new ArrayList<>();

	@CrossOrigin
	@GetMapping("/createTicket")
	public ResponseEntity createTicket(@RequestParam(value = "nomClient", defaultValue = "inconnu") String nomClient) {
		try {
			this.tickets.add(new Ticket(nomClient));
			return ResponseEntity.ok(nomClient);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@CrossOrigin
	@GetMapping("/addOnTicket")
	public ResponseEntity addOnTicket(
			@RequestParam(value = "idTicket", defaultValue = "0") Integer idTicket,
			@RequestParam(value = "nomArticle", defaultValue = "inconnu") String nomArticle,
			@RequestParam(value = "qtyArticle", defaultValue = "inconnu") Integer qty) {
		try {
			Ticket t = this.tickets.get(idTicket);
			t.addArticle(nomArticle, qty);
			return ResponseEntity.ok(nomArticle);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@CrossOrigin
	@GetMapping("/showOnTicket")
	public String showOnTicket(@RequestParam(value = "idTicket", defaultValue = "0") Integer idTicket) {
		try {
			Ticket t = this.tickets.get(idTicket);
			String res = t.allArticleToString();
			return res;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}