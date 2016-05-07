package hei.devweb.evenement.managers;

import hei.devweb.evenement.daos.UtilisateurDaoImpl;
import hei.devweb.evenement.entites.Utilisateur;

import java.util.List;

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

    public List<Utilisateur> listerPlanification() {
        return UtilisateurDao.listerPlanification();

    }

    public List<Utilisateur> listerCommission() {
        return UtilisateurDao.listerCommission();

    }

    public void modifierPlanification(String utilisateur_mail) {

        // TODO Auto-generated method stub
        System.out.println("UtilisateurManager : modifierPlanification " + utilisateur_mail);

        UtilisateurDao.modifierPlanification(utilisateur_mail);
    }


    public void modifierCommission(String utilisateur_mail) {

        // TODO Auto-generated method stub
        System.out.println("UtilisateurManager : modifierCommission " + utilisateur_mail);

        UtilisateurDao.modifierPlanification(utilisateur_mail);
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
