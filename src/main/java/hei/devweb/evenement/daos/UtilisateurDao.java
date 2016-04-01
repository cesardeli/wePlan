package hei.devweb.evenement.daos;

import hei.devweb.evenement.entites.Utilisateur;

public interface UtilisateurDao {

    public Utilisateur getUtilisateur(Integer utilisateur_id);

    public boolean verifierUtilisateur(String username, String password);


}