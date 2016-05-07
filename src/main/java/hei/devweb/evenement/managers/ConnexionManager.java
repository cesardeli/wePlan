package hei.devweb.evenement.managers;

import hei.devweb.evenement.daos.ConnexionDaoImpl;


/**
 * Created by Constance on 03/05/2016.
 */
public class ConnexionManager {
    private static ConnexionManager instance;

    private hei.devweb.evenement.daos.ConnexionDao ConnexionDao = new ConnexionDaoImpl();

    public static ConnexionManager getInstance() {
        if (instance == null) {
            instance = new ConnexionManager();
        }
        return instance;
    }

    private ConnexionManager() {
    }

    public boolean verifierUtilisateur(String utilisateur_mail, String utilisateur_mdp) {

        // TODO Auto-generated method stub
        System.out.println("Dans ConnexionManager : verifierUtilisateur" +utilisateur_mail +utilisateur_mdp);

        return ConnexionDao.verifierUtilisateur(utilisateur_mail, utilisateur_mdp);


    }

}
