package cn.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import cn.ecommerce.model.*;

public class ProduitDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ProduitDao(Connection con) {
		this.con = con;
	}
	
	
	public List<Produit> getAllProduit(){
		List<Produit> produits = new ArrayList<Produit>();
		
		try {
			query = "select * from produits";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Produit row = new Produit();
				row.setId_prd(rs.getInt("id_prd"));
				row.setPrix_prd(rs.getInt("prix_prd"));
				row.setNom_prd(rs.getString("nom_prd"));
				row.setCategorie_prd(rs.getString("categorie_prd"));
				row.setImage_prd(rs.getString("Image_prd"));
				
				produits.add(row);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return produits;
	}
}
