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

    public void modifierDroit(String utilisateur_mail) {

        // TODO Auto-generated method stub
        System.out.println("UtilisateurManager : modifierDroit " + utilisateur_mail);

        UtilisateurDao.modifierDroit(utilisateur_mail);
    }

    public void ajouterPlanification(String utilisateur_mail) {

        // TODO Auto-generated method stub
        System.out.println("UtilisateurManager : ajouterPlannification " + utilisateur_mail);

        UtilisateurDao.ajouterPlanification(utilisateur_mail);
    }

    public void ajouterCommission(String utilisateur_mail) {

        // TODO Auto-generated method stub
        System.out.println("UtilisateurManager : AjouterCommissionServlet " + utilisateur_mail);

        UtilisateurDao.ajouterCommission(utilisateur_mail);
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

    public void modifierMDP(String utilisateur_mail, String utilisateur_mdp) {
// TODO Auto-generated method stub
        System.out.println("Dans UtilisateurManager : modifierMDP");

        try {
            UtilisateurDao.modifierMDP(utilisateur_mail, utilisateur_mdp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
