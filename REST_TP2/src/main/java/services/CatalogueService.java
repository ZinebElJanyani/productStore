package services;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import entities.Categorie;
import entities.Produit;
import metier.CatalogueMetierImp;
import metier.ICatalogueMetier;

@Singleton
@Path("/catalogue")
public class CatalogueService {
	private ICatalogueMetier catalogueMetier = new CatalogueMetierImp();

	@POST
	@Path("/ajouterCatg")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Categorie ajouterCategorie(Categorie categorie) {
		return this.catalogueMetier.addCategorie(categorie);
	}
	
	@POST
	@Path("/ajouterPrd")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Produit ajouterProduit(Produit prod) {
		return this.catalogueMetier.addProduit(prod);

	}
	
	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categorie> listCategories(){
		return this.catalogueMetier.getCategories();
	}
	
	@GET
	@Path("/categorie/{idc}")
	@Produces(MediaType.APPLICATION_JSON)
	public Categorie consulterCategorie(@PathParam("idc") Long id) {
		return this.catalogueMetier.consulterCategorie(id);
	}
	
	//http://localhost:8080/REST_TP2/api/catalogue/produit?idp=1
	@GET
	@Path("/produit")
	@Produces(MediaType.APPLICATION_JSON)
	public Produit consulterProduit(@QueryParam("idp")  Long id) {
		return this.catalogueMetier.consulterProduit(id);
	}
	
	@GET
	@Path("/categories/{idc}/produits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> produitsParCat(@PathParam("idc") Long idCat){
		return this.catalogueMetier.produitsParCat(idCat);
	}
	
	@GET
	@Path("/produits/{des}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> produitsParDes(@PathParam("des")String designation){
		return this.catalogueMetier.produitsParDes(designation);
	}
	
	@PUT
	@Path("/categorie")
	@Produces(MediaType.APPLICATION_JSON)
	public Categorie updateCategorie( Categorie categorie) {
		return this.catalogueMetier.updateCategorie(categorie);
	}
	
	@PUT
	@Path("/produits")
	@Produces(MediaType.APPLICATION_JSON)
	public Produit updateProduit(Produit produit) {
		return this.catalogueMetier.updateProduit(produit);
	}
	
	@DELETE
	@Path("/supp/{idp}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean supprimerProduit(@PathParam("idp") Long id) {
		return this.catalogueMetier.supprimerProduit(id);
	}
}
