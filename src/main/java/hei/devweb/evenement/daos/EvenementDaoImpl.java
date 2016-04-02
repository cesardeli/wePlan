package hei.devweb.evenement.daos;

import hei.devweb.evenement.entites.Evenement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EvenementDaoImpl implements EvenementDao {

    @Override
    public List<Evenement> listerEvenements() {
        List<Evenement> listeEvenements = new ArrayList<Evenement>();
        try {
            // Créer une nouvelle connexion à la BDD
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            // Utiliser la connexion
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM evenement");
            while (results.next()) {

                listeEvenements.add(new Evenement(
                                results.getInt("evenement_id"),
                                results.getString("evenement_nom"),
                                results.getString("evenement_lieu"),
                                results.getBoolean("evenement_prive"),
                                results.getDate("evenement_date_debut"),
                                results.getTime("evenement_heure_debut"),
                                results.getDate("evenement_date_fin"),
                                results.getTime("evenement_heure_fin"),
                                results.getString("evenement_description")
                        )
                );
            }

            stmt.close();

        } catch (

                SQLException e)

        {

            e.printStackTrace();
        }
        return listeEvenements;
    }


    @Override
    public void supprimerEvenement(Integer evenement_id) {

        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            // Utiliser la connexion
            PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM evenement WHERE evenement_id=?");
            stmt.setInt(1, evenement_id);
            stmt.executeUpdate();
            stmt.close();

            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void ajouterEvenement(Evenement evenement) {


        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO `evenement`(`evenement_nom`, `evenement_lieu`, /*`evenement_date_debut`, `evenement_date_fin`,*/ `evenement_description`) VALUES(?, ?, /*?, ?,*/ ?)");


            stmt.setString(1, evenement.getEvenement_nom());
            stmt.setString(2, evenement.getEvenement_lieu());
            //stmt.setBoolean(3, false);

           /* stmt.setDate(3, new Date(evenement.getEvenement_date_debut().getTime()));
            stmt.setDate(4, new Date(evenement.getEvenement_date_fin().getTime()));*/
            stmt.setString(3, evenement.getEvenement_description());
            stmt.executeUpdate();
            stmt.close();


            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void modifierEvenement(Evenement evenement) {
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE  evenement SET evenement_nom=?, evenement_lieu=?, evenement_prive=?, evenement_description=? WHERE evenement_id=? ");
            stmt.setString(1, evenement.getEvenement_nom());
            stmt.setString(2, evenement.getEvenement_lieu());
            stmt.setBoolean(3, evenement.getEvenement_prive());
            stmt.setString(4, evenement.getEvenement_description());
            stmt.setInt(5, evenement.getEvenement_id());
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
