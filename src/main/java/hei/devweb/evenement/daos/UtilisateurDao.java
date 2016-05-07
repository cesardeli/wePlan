package hei.devweb.evenement.daos;

import hei.devweb.evenement.entites.Evenement;
import hei.devweb.evenement.entites.Utilisateur;

import java.util.List;

/**
 * Created by Constance on 20/04/2016.
 */
public interface UtilisateurDao  {
    public void ajouterUtilisateur(Utilisateur utilisateur);

    public List<Utilisateur> listerPlanification();

    public List<Utilisateur> listerCommission();

    public void modifierPlanification(String utilisateur_mail);

    public void modifierCommission(String utilisateur_mail);




}

