package hei.devweb.evenement.managers;

import hei.devweb.evenement.daos.EvenementDao;
import hei.devweb.evenement.daos.EvenementDaoImpl;
import hei.devweb.evenement.entites.Evenement;

import java.util.List;

public class EvenementManager {

    private static EvenementManager instance;

    private EvenementDao EvenementDao = new EvenementDaoImpl();

    public static EvenementManager getInstance() {
        if (instance == null) {
            instance = new EvenementManager();
        }
        return instance;
    }

    private EvenementManager() {
    }

    public List<Evenement> listerEvenements() {
        return EvenementDao.listerEvenements();

    }


    public void ajouterEvenement(Evenement nouvelEvenement) {
        // TODO Auto-generated method stub
        System.out.println("Dans Méthode : ajouterEvenement");
        /*
        if (nouvelEvenement == null) {
			throw new IllegalArgumentException("L'évenement à ajouter ne peut pas être null.");
		}
		*/
        EvenementDao.ajouterEvenement(nouvelEvenement);
    }


    public void modifierEvenement(Evenement newEvenement) {

        // TODO Auto-generated method stub
        System.out.println("Dans Méthode : modifierEvenement");

        EvenementDao.modifierEvenement(newEvenement);
    }

    public void supprimerEvenement(Integer evenement_id) {


        EvenementDao.supprimerEvenement(evenement_id);
    }
}
