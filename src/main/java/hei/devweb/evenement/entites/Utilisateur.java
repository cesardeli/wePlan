package hei.devweb.evenement.entites;

import java.io.Serializable;

public class Utilisateur  {


	private Integer utilisateur_id;
	private String utilisateur_mail;
	private String utilisateur_mdp;



	public int getUtilisateur_id() {
		return utilisateur_id;
	}
	public void setUtilisateur_id(int utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}
	public String getUtilisateur_mail() {
		return utilisateur_mail;
	}
	public void setUtilisateur_mail(String utilisateur_mail) {
		this.utilisateur_mail = utilisateur_mail;
	}
	public String getUtilisateur_mdp() {
		return utilisateur_mdp;
	}
	public void setUtilisateur_mdp(String utilisateur_mdp) {
		this.utilisateur_mdp = utilisateur_mdp;
	}
	public Utilisateur(Integer utilisateur_id, String utilisateur_mail, String utilisateur_mdp) {
		super();
		this.utilisateur_id = utilisateur_id;
		this.utilisateur_mail = utilisateur_mail;
		this.utilisateur_mdp = utilisateur_mdp;
	}
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

}



