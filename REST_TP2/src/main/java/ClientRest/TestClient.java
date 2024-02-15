package ClientRest;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Categorie;
import entities.Produit;

public class TestClient {

	public static void main(String[] args) throws Exception {
		Client c = ClientBuilder.newClient();
		//des method get (un seul et une collection d'objets)
		/*WebTarget target = c.target("http://localhost:8080/REST_TP2/api/catalogue/produit")
				.queryParam("idp", 2L);
		Produit p = target.request().get(Produit.class);
		System.out.println(p.getDesignation());*/
		
		/*
		WebTarget target = c.target("http://localhost:8080/REST_TP2/api/catalogue/categories");	
		String corpshttp = target.request().get(String.class);
		
		System.out.println(corpshttp);
		ObjectMapper mapper = new ObjectMapper();
		Categorie[] cats = mapper.readValue(corpshttp, Categorie[].class);
		for (Categorie ct : cats) {
			System.out.println(ct.getNom());
		}*/
		
		//method post
		Categorie cat1 = new Categorie(6L,"tabletes" , "or1.jpg");
	
		Produit p1 = new Produit(1L,"HP",20000D,"hp.jpg",cat1);
		String catjson="{\r\n"
				+ "        \"idProd\": 22,\r\n"
				+ "        \"designation\": \"APPLE\",\r\n"
				+ "        \"prix\": 70000.0,\r\n"
				+ "        \"photo\": \"Ap.jpg\",\r\n"
				+ "        \"categorie\": {\r\n"
				+ "            \"id\": 1,\r\n"
				+ "            \"nom\": \"ordinateurs\",\r\n"
				+ "            \"photo\": \"or1.jpg\"\r\n"
				+ "        }\r\n"
				+ "    }";
		WebTarget target = c.target("http://localhost:8080/REST_TP2/api/catalogue/ajouterPrd");
				
		Produit p = target.request().post(Entity.entity(catjson, MediaType.APPLICATION_JSON),Produit.class);
		
		System.out.println("le produit ajouté est :"+p.getIdProd());
		/*URI uri = UriBuilder.fromUri("http://localhost:8080/REST_TP2/api").build();
		ClientResponse response = Client.create =< prob*/
		
	}

}
