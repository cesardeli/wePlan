package hei.devweb.evenement.entites;

import java.sql.Time;
import java.util.Date;

public class Evenement {
	
	private Integer evenement_id;
	private String evenement_nom;
	private String evenement_lieu;
	private Boolean evenement_prive;
	private Date evenement_date_debut;
	private Time evenement_heure_debut;
	private Date evenement_date_fin;
	private Time evenement_heure_fin;
	private String evenement_description;
	

	

	
	
	
	
	public Evenement(Integer evenement_id, String evenement_nom, String evenement_lieu, Boolean evenement_prive,
			Date evenement_date_debut, Time evenement_heure_debut, Date evenement_date_fin, Time evenement_heure_fin,
			String evenement_description) {
		super();
		this.evenement_id = evenement_id;
		this.evenement_nom = evenement_nom;
		this.evenement_lieu = evenement_lieu;
		this.evenement_prive = evenement_prive;
		this.evenement_date_debut = evenement_date_debut;
		this.evenement_heure_debut = evenement_heure_debut;
		this.evenement_date_fin = evenement_date_fin;
		this.evenement_heure_fin = evenement_heure_fin;
		this.evenement_description = evenement_description;
	}








	public Integer getEvenement_id() {
		return evenement_id;
	}








	public void setEvenement_id(Integer evenement_id) {
		this.evenement_id = evenement_id;
	}








	public String getEvenement_nom() {
		return evenement_nom;
	}








	public void setEvenement_nom(String evenement_nom) {
		this.evenement_nom = evenement_nom;
	}








	public String getEvenement_lieu() {
		return evenement_lieu;
	}








	public void setEvenement_lieu(String evenement_lieu) {
		this.evenement_lieu = evenement_lieu;
	}








	public Boolean getEvenement_prive() {
		return evenement_prive;
	}








	public void setEvenement_prive(Boolean evenement_prive) {
		this.evenement_prive = evenement_prive;
	}








	public Date getEvenement_date_debut() {
		return evenement_date_debut;
	}








	public void setEvenement_date_debut(Date evenement_date_debut) {
		this.evenement_date_debut = evenement_date_debut;
	}








	public Time getEvenement_heure_debut() {
		return evenement_heure_debut;
	}








	public void setEvenement_heure_debut(Time evenement_heure_debut) {
		this.evenement_heure_debut = evenement_heure_debut;
	}








	public Date getEvenement_date_fin() {
		return evenement_date_fin;
	}








	public void setEvenement_date_fin(Date evenement_date_fin) {
		this.evenement_date_fin = evenement_date_fin;
	}








	public Time getEvenement_heure_fin() {
		return evenement_heure_fin;
	}








	public void setEvenement_heure_fin(Time evenement_heure_fin) {
		this.evenement_heure_fin = evenement_heure_fin;
	}








	public String getEvenement_description() {
		return evenement_description;
	}








	public void setEvenement_description(String evenement_description) {
		this.evenement_description = evenement_description;
	}
	
}
