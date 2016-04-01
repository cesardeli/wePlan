package hei.devweb.evenement.daos;

import hei.devweb.evenement.entites.Evenement;

import java.util.List;

public interface EvenementDao {

	public List<Evenement> listerEvenements();

	public void supprimerEvenement(Integer evenement_id);
	
	public void ajouterEvenement(Evenement evenement);
	
	public void modifierEvenement(Evenement evenement);

}