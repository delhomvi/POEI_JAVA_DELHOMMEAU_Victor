package com.delhomvictor.tpOne.delhomvictor;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TicketCaisse {
	private final AtomicLong counter = new AtomicLong();
	ArrayList<Article> articles = new ArrayList<>();
	String clientName = "";
	
	@PostMapping("addArticle")
	public ResponseEntity addArticle(@RequestBody Article article) {
		this.articles.add(article);
		article.setID(counter.incrementAndGet());
		return ResponseEntity.ok(article);
		
	}
	
	@PostMapping("addClient")
	public ResponseEntity addArticle(@RequestBody String client) {
		this.clientName=client;
		return ResponseEntity.ok(client);
	}
	
	@GetMapping("getBill")
	public JsonNode getBill(HttpServletRequest request) {
		Integer totalPrice = 0;
		for(Article article : this.articles) {
			totalPrice+=article.getPrix();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayItem = mapper.valueToTree(this.articles);
		JsonNode listeArticlesToNode = mapper.createObjectNode();
		((ObjectNode) listeArticlesToNode).put("name", this.clientName);
		((ObjectNode) listeArticlesToNode).put("prix", totalPrice.toString());
		((ObjectNode) listeArticlesToNode).set("list", listeArticlesToNode);
		return listeArticlesToNode;
		
	}
}
