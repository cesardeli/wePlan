package hei.devweb.evenement.daos;

import hei.devweb.evenement.entites.Utilisateur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class ConnexionDaoImpl implements ConnexionDao {
    public Utilisateur getUtilisateur() {

        Utilisateur utilisateur = new Utilisateur(null, null, null,null);

        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur");
            while(results.next()) {
                utilisateur.setUtilisateur_id(results.getInt("utilisateur_id"));
                utilisateur.setUtilisateur_mail(results.getString("utilisateur_mail"));
                utilisateur.setUtilisateur_mdp(results.getString("utilisateur_mdp"));
                utilisateur.setUtilisateur_type(results.getInt("utilisateur_type"));
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }



    @Override
    public boolean verifierUtilisateur(String utilisateur_mail, String utilisateur_mdp) {

        System.out.println("ConnexionDaoImpl : verifierUtilisateur " +utilisateur_mail +" " +utilisateur_mdp);


        String motdepasseUtilisateur = "";

        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT utilisateur_mdp FROM utilisateur WHERE utilisateur_mail = '"+utilisateur_mail+"'");
            while (results.next()) {
                motdepasseUtilisateur = results.getString("utilisateur_mdp");
                System.out.println("motdepassUtilisateur : " +motdepasseUtilisateur);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(motdepasseUtilisateur != ""){
            System.out.println("ConnexionDaoImpl : premier If");

            if(motdepasseUtilisateur.equals(utilisateur_mdp)) {
                System.out.println("ConnexionDaoImpl : verifierUtilisateur : if(motdepasse.......)");

                return true;
            }else{
                System.out.println("ConnexionDaoImpl : verifierUtilisateur : if(motdepasse.......) : else");

                return false;
            }
        }
        System.out.println("ConnexionDaoImpl: verifier mot de passe : else");

        return false;
    }
}
