package com.delhomvictor.tpOne.delhomvictor;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

//import org.json.XML;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class MegaController {

	public static JSONObject getJsonFromURL(String urlString) {
		try {
			URL url = new URL(urlString);
			ObjectMapper objectMapper = new ObjectMapper();

			// JSONObject json = objectMapper.readValue(new FileInputStream("velo.json"),
			// Map.class);
			JSONObject json = objectMapper.readValue(url.openStream(), JSONObject.class);
			return json;
		} catch (Exception e) {
			return null;
		}
	}

	@CrossOrigin
	@GetMapping("/parking")
	public String parkingBrut(HttpServletRequest request) {
		try {

			JSONObject json = getJsonFromURL(
					"https://opendata.lillemetropole.fr/api/records/1.0/search/?dataset=comptages-velo&q=&facet=llecocompteur&facet=lldirection&facet=dateh&facet=ville");
			return json.toString();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@CrossOrigin
	@GetMapping("/velo")
	public Map<?, ?> velo(HttpServletRequest request) {
		try {
			String urlString = "https://opendata.lillemetropole.fr/api/records/1.0/search/?dataset=comptages-velo&q=&facet=llecocompteur&facet=lldirection&facet=dateh&facet=ville";

			// ouverture du flux (stream) de l'url
			URL url = new URL(urlString);

			// creation d'un mapper qui va permettre de faire correspondre des données
			// organisées (json) en un container (map)
			ObjectMapper objectMapper = new ObjectMapper();

			// Map<?, ?> map = objectMapper.readValue(new FileInputStream("velo.json"),
			// Map.class);
			// le mapper va recevoir le flus (stream) et le convertir en Map
			Map<?, ?> map = objectMapper.readValue(url.openStream(), Map.class);

			// iterate over map entries and print to console
			/*
			 * for (Map.Entry<?, ?> entry : map.entrySet() ) {
			 * System.out.println(entry.getKey() + "=" + entry.getValue()); }
			 */
			return map;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@CrossOrigin
	@GetMapping("/veloVille")
	public ArrayList<String> veloVille(HttpServletRequest request) {
		ArrayList<String> listVille = new ArrayList<String>(); // initialisaton de la liste des villes
		try {
			// Url de la query
			String urlString = "https://opendata.lillemetropole.fr/api/records/1.0/search/?dataset=comptages-velo&q=&facet=llecocompteur&facet=lldirection&facet=dateh&facet=ville";
			URL url = new URL(urlString);
			// Génère ton mapper
			ObjectMapper objectMapper = new ObjectMapper();
			// Ouvre le stream
			JsonNode rootNode = objectMapper.readTree(url.openStream());
			// Va chercher les données
			String titre = rootNode.path("parameters").path("dataset").asText();
			JsonNode facets_ville = rootNode.path("facet_groups").get(3).path("facets");
			// Si on a bien un array
			if (facets_ville.isArray()) {
				for (final JsonNode dataVille : facets_ville) {
					// Cherche la ville et l'ajoute à la liste
					String ville = dataVille.path("name").asText();
					listVille.add(ville);
				}
				// Retourne la liste de la ville
				return listVille;
			} else
				// Sinon retourne null
				return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	@CrossOrigin
	@GetMapping("/prenom")
	public Map<?, ?> prenom(@RequestParam(value="prenom", defaultValue = "inconnu") String prenom) {
		try {
			System.out.println(prenom);
			String urlString = "https://api.agify.io/?name="+prenom;
			URL url = new URL(urlString);
			ObjectMapper objectMapper = new ObjectMapper();
			Map<?, ?> map = objectMapper.readValue(url.openStream(), Map.class);
			return map;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@CrossOrigin
	@GetMapping("/veloVillSet")
	public JsonNode veloVilleSet(HttpServletRequest request) {
		ArrayList<String> listVille = new ArrayList<String>();
		try {
			String urlString = "https://opendata.lillemetropole.fr/api/records/1.0/search/?dataset=comptages-velo&q=&facet=llecocompteur&facet=lldirection&facet=dateh&facet=ville";
			URL url = new URL(urlString);

			ObjectMapper objectMapper = new ObjectMapper();

			// read customer.json file into a tree model
			JsonNode rootNode = objectMapper.readTree(url.openStream());

			String titre = rootNode.path("parameters").path("dataset").asText();

			JsonNode facets_ville = rootNode.path("facet_groups").get(3).path("facets");
			if (facets_ville.isArray()) {
				for (final JsonNode objNode : facets_ville) {
					String ville = objNode.path("name").asText();
					System.out.println(ville);
					listVille.add(ville);
				}
				ObjectMapper mapper = new ObjectMapper();

				ArrayNode arrayVeloNode = mapper.valueToTree(listVille);
				JsonNode listeVeloNode = mapper.createObjectNode();
				((ObjectNode) listeVeloNode).put("titre", titre);
				((ObjectNode) listeVeloNode).set("list", arrayVeloNode);
				return listeVeloNode;
			} else
				return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}