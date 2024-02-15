package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import entities.Categorie;
import entities.Produit;

public class CatalogueMetierImp implements ICatalogueMetier{
	
	private HashMap<Long,Produit> produits;
	private HashMap<Long,Categorie> categories;

	
	
	public CatalogueMetierImp() {
		super();
		this.categories = new HashMap<Long,Categorie>();
		this.produits = new HashMap<Long,Produit>();
		this.initialiserCatalogue();
		System.out.println("koko");
	}

	@Override
	public Categorie addCategorie(Categorie categorie) {
		categories.put(categorie.getId(), categorie);
		return categories.get(categorie.getId());
	}

	@Override
	public Produit addProduit(Produit prod) {
		prod.setCategorie(consulterCategorie( prod.getCategorie().getId() ));
		produits.put(prod.getIdProd(), prod);
		return produits.get(prod.getIdProd());
	}

	@Override
	public List<Categorie> getCategories() {
		
		return new ArrayList<Categorie>(categories.values());
	}

	@Override
	public Categorie consulterCategorie(Long id) {
		return categories.get(id);
	}

	@Override
	public Produit consulterProduit(Long id) {
		return produits.get(id);
	}

	@Override
	public List<Produit> produitsParCat(Long idCat) {
		//ArrayList<Produit> produitst = new ArrayList<>(produits.values());
		return 	this.produits.values().stream().filter(p -> p.getCategorie().getId().equals(idCat)).collect(Collectors.toList());

	}

	@Override
	public List<Produit> produitsParDes(String designation) {
		return produits.values().stream().filter(p -> p.getDesignation().equals(designation)).collect(Collectors.toList());

	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		Categorie cat = categories.get(categorie.getId());
		cat.setNom(categorie.getNom());
		cat.setPhoto(categorie.getPhoto());
		return categorie;
	}

	@Override
	public Produit updateProduit(Produit produit) {
		Produit p = produits.get(produit.getIdProd());
		p.setDesignation(produit.getDesignation());
		p.setPhoto(produit.getPhoto());
		p.setPrix(produit.getPrix());
		p.setCategorie(categories.get(produit.getCategorie().getId()));
		return p;
	}

	@Override
	public boolean supprimerProduit(Long id) {
		if(produits.containsKey(id)) {
		produits.remove(id);
		return true;
		}
		return false;
	}

	public void initialiserCatalogue() {
		this.addCategorie(new Categorie(1L,"ordinateurs" , "or1.jpg"));
		this.addCategorie(new Categorie(2L,"Imprimantes" , "or1.jpg"));
		this.addCategorie(new Categorie(3L,"Téléviseurs" , "or1.jpg"));

		
		this.addProduit(new Produit(1L,"HP",20000D,"hp.jpg",categories.get(1L)));
		this.addProduit(new Produit(2L,"Dell",30000D,"dell.jpg",categories.get(1L)));
		
		this.addProduit(new Produit(3L,"hp imprim",40000D,"hp.jpg",categories.get(2L)));
		this.addProduit(new Produit(4L,"lENVO imprim",30000D,"hp.jpg",categories.get(2L)));
		
		this.addProduit(new Produit(5L,"LG",20000D,"hp.jpg",categories.get(3L)));
		this.addProduit(new Produit(6L,"sumsung",20000D,"hp.jpg",categories.get(3L)));

		this.addProduit(new Produit(7L,"mac",40000D,"hp.jpg",categories.get(1L)));
		
		

	}
}
