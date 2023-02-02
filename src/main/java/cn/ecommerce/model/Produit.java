package cn.ecommerce.model;

public class Produit {
	private int id_prd;
	private int prix_prd;
	private String nom_prd;
	private String categorie_prd;
	private String image_prd;
	
	
	public Produit() {
		
	}


	public Produit(int id_prd, int prix_prd, String nom_prd, String categorie_prd, String image_prd) {
		super();
		this.id_prd = id_prd;
		this.prix_prd = prix_prd;
		this.nom_prd = nom_prd;
		this.categorie_prd = categorie_prd;
		this.image_prd = image_prd;
	}


	public int getId_prd() {
		return id_prd;
	}


	public void setId_prd(int id_prd) {
		this.id_prd = id_prd;
	}


	public int getPrix_prd() {
		return prix_prd;
	}


	public void setPrix_prd(int prix_prd) {
		this.prix_prd = prix_prd;
	}


	public String getNom_prd() {
		return nom_prd;
	}


	public void setNom_prd(String nom_prd) {
		this.nom_prd = nom_prd;
	}


	public String getCategorie_prd() {
		return categorie_prd;
	}


	public void setCategorie_prd(String categorie_prd) {
		this.categorie_prd = categorie_prd;
	}


	public String getImage_prd() {
		return image_prd;
	}


	public void setImage_prd(String image_prd) {
		this.image_prd = image_prd;
	}


	@Override
	public String toString() {
		return "Produit [id_prd=" + id_prd + ", prix_prd=" + prix_prd + ", nom_prd=" + nom_prd + ", categorie_prd="
				+ categorie_prd + ", image_prd=" + image_prd + "]";
	}

	
	
}
