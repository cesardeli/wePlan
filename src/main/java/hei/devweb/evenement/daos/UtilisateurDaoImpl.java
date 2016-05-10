package hei.devweb.evenement.daos;

import hei.devweb.evenement.entites.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Constance on 20/04/2016.
 */
public class UtilisateurDaoImpl implements UtilisateurDao {

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO utilisateur(utilisateur_mail, utilisateur_mdp, utilisateur_type) VALUES(?, ?, ?)");


            stmt.setString(1, utilisateur.getUtilisateur_mail());
            stmt.setString(2, utilisateur.getUtilisateur_mdp());
            stmt.setInt(3, utilisateur.getUtilisateur_type());


            stmt.executeUpdate();
            stmt.close();


            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Utilisateur> listerPlanification() {
        System.out.println("UtilisateurDaoImpl listerPlanification");
        List<Utilisateur> listePlanification = new ArrayList<Utilisateur>();
        try {
            // Créer une nouvelle connexion à la BDD
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            // Utiliser la connexion
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur WHERE utilisateur_type =2 ");
            while (results.next()) {

                listePlanification.add(new Utilisateur(
                                results.getInt("utilisateur_id"),
                                results.getString("utilisateur_mail"),
                                results.getString("utilisateur_mdp"),
                                results.getInt("utilisateur_type")
                        )
                );
            }

            stmt.close();

        } catch (

                SQLException e)

        {

            e.printStackTrace();
        }
        return listePlanification;
    }


    @Override
    public List<Utilisateur> listerCommission() {
        System.out.println("UtilisateurDaoImpl listerCommission");
        List<Utilisateur> listeCommission = new ArrayList<Utilisateur>();
        try {
            // Créer une nouvelle connexion à la BDD
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            // Utiliser la connexion
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur WHERE utilisateur_type =1 ");
            while (results.next()) {

                listeCommission.add(new Utilisateur(
                                results.getInt("utilisateur_id"),
                                results.getString("utilisateur_mail"),
                                results.getString("utilisateur_mdp"),
                                results.getInt("utilisateur_type")
                        )
                );
            }

            stmt.close();

        } catch (

                SQLException e)

        {

            e.printStackTrace();
        }
        return listeCommission;
    }


    @Override
    public void modifierDroit(String utilisateur_mail) {
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE  utilisateur SET utilisateur_type=0 WHERE utilisateur_mail=? ");

            stmt.setString(1, utilisateur_mail);


            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void ajouterPlanification(String utilisateur_mail) {
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE  utilisateur SET utilisateur_type=2 WHERE utilisateur_mail=? ");

            stmt.setString(1, utilisateur_mail);


            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ajouterCommission(String utilisateur_mail) {
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE  utilisateur SET utilisateur_type=1 WHERE utilisateur_mail=? ");

            stmt.setString(1, utilisateur_mail);


            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierMDP(String utilisateur_mail, String utilisateur_mdp) {
        try

        {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE  utilisateur SET utilisateur_mdp=? WHERE utilisateur_mail=?");

            stmt.setString(1, utilisateur_mdp);
            stmt.setString(2, utilisateur_mail);

            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (
                SQLException e
                )

        {
            e.printStackTrace();
        }

    }


}
