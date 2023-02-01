package cn.ecommerce.model;

public class Utilisateur {
	private int id_ut;
	private String nom_ut;
	private String email_ut;
	private String pwd_ut;
	
	
	public Utilisateur() {

	}


	public Utilisateur(int id_ut, String nom_ut, String email_ut, String pwd_ut) {
		this.id_ut = id_ut;
		this.nom_ut = nom_ut;
		this.email_ut = email_ut;
		this.pwd_ut = pwd_ut;
	}


	public int getId_ut() {
		return id_ut;
	}


	public void setId_ut(int id_ut) {
		this.id_ut = id_ut;
	}


	public String getNom_ut() {
		return nom_ut;
	}


	public void setNom_ut(String nom_ut) {
		this.nom_ut = nom_ut;
	}


	public String getEmail_ut() {
		return email_ut;
	}


	public void setEmail_ut(String email_ut) {
		this.email_ut = email_ut;
	}


	public String getPwd_ut() {
		return pwd_ut;
	}


	public void setPwd_ut(String pwd_ut) {
		this.pwd_ut = pwd_ut;
	}
	
	
	
}
