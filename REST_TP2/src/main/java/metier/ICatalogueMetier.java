package metier;

import java.util.List;

import entities.Categorie;
import entities.Produit;

public interface ICatalogueMetier {

	public Categorie addCategorie(Categorie categorie);
	public Produit addProduit(Produit prod);
	public List<Categorie> getCategories();
	public Categorie consulterCategorie(Long id);
	public Produit consulterProduit(Long id);
	public List<Produit> produitsParCat(Long idCat);
	public List<Produit> produitsParDes(String designation);
	public Categorie updateCategorie(Categorie categorie);
	public Produit updateProduit(Produit produit);
	public boolean supprimerProduit(Long id);
}
