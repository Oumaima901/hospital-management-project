package gest.hosp.web.model;

import java.io.Serializable;

public class Patient  implements Serializable {
	
	private int id;
	private String nom_pat;
	private String prenom;
	private String email;
	private String numero;
	private String adresse;
	private String nom;
	
	
	public Patient(int id, String nom_pat, String prenom, String email, String numero, String adresse, String nom) {
		super();
		this.id = id;
		this.nom_pat = nom_pat;
		this.prenom = prenom;
		this.email = email;
		this.numero = numero;
		this.adresse = adresse;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Patient() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_pat() {
		return nom_pat;
	}
	public void setNom_pat(String nom_pat) {
		this.nom_pat = nom_pat;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

	


}
