package entities;

import java.io.Serializable;

public class Categorie implements Serializable{

	private Long id;
	private String nom;
	private String photo;
	
	
	
	public Categorie() {
		super();
	}
	public Categorie(Long id, String nom, String photo) {
		super();
		this.id = id;
		this.nom = nom;
		this.photo = photo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
