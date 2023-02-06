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
	
	public List<Panier> getProduitsPanier(ArrayList<Panier> panierList) {
		List<Panier> produits_p = new ArrayList<Panier>();
		
		try {
			if(panierList.size() > 0) {
				for (Panier item:panierList) {
					query = "select * from produits where id_prd=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getId_prd());
					rs = pst.executeQuery();
					
					while(rs.next()) {
						Panier row = new Panier();
						row.setId_prd(rs.getInt("id_prd"));
						row.setNom_prd(rs.getString("nom_prd"));
						row.setCategorie_prd(rs.getString("categorie_prd"));
						row.setPrix_prd(rs.getDouble("prix_prd")*item.getQuantite());
						row.setQuantite(item.getQuantite());
						produits_p.add(row);
					}
				}
			}
		} 
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
			
		
		return produits_p;
	}
}
