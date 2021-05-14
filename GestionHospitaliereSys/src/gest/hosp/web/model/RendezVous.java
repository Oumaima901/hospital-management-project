package gest.hosp.web.model;

import java.io.Serializable;

public class RendezVous implements Serializable {
	private int id;
	private String date ;
	private String heure;
	private String nom_pat;
	
	public RendezVous() {
		super();
	}
	public RendezVous(int id, String date, String heure, String nom_pat) {
		super();
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.nom_pat = nom_pat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public String getNom_pat() {
		return nom_pat;
	}
	public void setNom_pat(String nom_pat) {
		this.nom_pat = nom_pat;
	}
	

	
	

}
