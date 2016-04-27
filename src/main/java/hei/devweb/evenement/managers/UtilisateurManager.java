package hei.devweb.evenement.managers;

import hei.devweb.evenement.daos.UtilisateurDao;
import hei.devweb.evenement.daos.UtilisateurDaoImpl;
import hei.devweb.evenement.daos.UtilisateurDaoImpl;
import hei.devweb.evenement.entites.Evenement;
import hei.devweb.evenement.entites.Utilisateur;

/**
 * Created by Constance on 20/04/2016.
 */
public class UtilisateurManager {
    private static UtilisateurManager instance;

    private hei.devweb.evenement.daos.UtilisateurDao UtilisateurDao = new UtilisateurDaoImpl();

    public static UtilisateurManager getInstance() {
        if (instance == null) {
            instance = new UtilisateurManager();
        }
        return instance;
    }

    public void ajouterUtilisateur(Utilisateur nouvelUtilisateur) {
        // TODO Auto-generated method stub
        System.out.println("Dans Méthode : ajouterUtilisateur");
        /*
        if (nouvelEvenement == null) {
			throw new IllegalArgumentException("L'évenement à ajouter ne peut pas être null.");
		}
		*/
        UtilisateurDao.ajouterUtilisateur(nouvelUtilisateur);
    }


}
