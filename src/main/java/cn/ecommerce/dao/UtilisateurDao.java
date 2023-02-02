package cn.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.ecommerce.model.Utilisateur;

public class UtilisateurDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public UtilisateurDao(Connection con) {
		super();
		this.con = con;
	}
	
	public Utilisateur login_ut(String email_ut, String pwd_ut) {
		Utilisateur utilisateur = null;
		
		try {
			query = "select * from utilisateurs where email_ut=? and pwd_ut=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, email_ut);
			pst.setString(2, pwd_ut);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setId_ut(rs.getInt("id_ut"));
				utilisateur.setNom_ut(rs.getString("nom_ut"));
				utilisateur.setEmail_ut(rs.getString("email_ut"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		return utilisateur;
	}
	
}
