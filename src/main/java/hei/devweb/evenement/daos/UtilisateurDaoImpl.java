package hei.devweb.evenement.daos;

import hei.devweb.evenement.entites.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Constance on 20/04/2016.
 */
public class UtilisateurDaoImpl implements UtilisateurDao {

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public void ajouterUtilisateur( Utilisateur utilisateur )  {
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO `utilisateur`(`utilisateur_mail`, `utilisateur_mdp`) VALUES(?, ?)");


            stmt.setString(1, utilisateur.getUtilisateur_mail());
            stmt.setString(2, utilisateur.getUtilisateur_mdp());

            stmt.executeUpdate();
            stmt.close();


            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
