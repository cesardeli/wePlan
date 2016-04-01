package hei.devweb.evenement.managers;

import hei.devweb.evenement.daos.UtilisateurDao;
import hei.devweb.evenement.daos.UtilisateurDaoImpl;
import hei.devweb.evenement.entites.Utilisateur;

public class UtilisateurManager {
	private static UtilisateurManager instance;
	private UtilisateurDao utilisateurDao = new UtilisateurDaoImpl();
	
	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	public Utilisateur getUtilisateur(Integer utilisateur_id) {
		return utilisateurDao.getUtilisateur(utilisateur_id);
	}
	
	public boolean verifierUtilisateur(String username, String password) {
		return utilisateurDao.verifierUtilisateur(username, password);
	}

}