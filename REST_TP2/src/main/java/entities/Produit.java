package entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Produit implements Serializable{

	private Long idProd;
	private String designation;
	private double prix;
	private String photo;
	private Categorie categorie;
	
	
	public Produit() {
		super();
	}
	public Produit(Long idProd, String designation, double prix, String photo, Categorie categorie) {
		super();
		this.idProd = idProd;
		this.designation = designation;
		this.prix = prix;
		this.photo = photo;
		this.categorie = categorie;
	}
	
	public Long getIdProd() {
		return idProd;
	}
	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}
	
	@JsonIgnore  //quand le produit va etre transformer en json par jackson il va 
	//ignorer la category et ell ne va pas la serialiser c'est l'equivalent de @xmlTransit pour @xmlRootElement si on utilise Jaxb
	//afin d'eviter que les objet lieé apporte tous leurs liasons
	public Categorie getCategorie() {
		return categorie;
	}
	@JsonSetter
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
