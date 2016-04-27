package hei.devweb.evenement.daos;

import hei.devweb.evenement.entites.Evenement;
import hei.devweb.evenement.entites.Utilisateur;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Constance on 20/04/2016.
 */
public class UtilisateurDaoTestCase {
    private UtilisateurDao utilisateurDao = new UtilisateurDaoImpl();
    @Before
    public void initBdd() throws Exception {
        Connection connection = DataSourceProvider.getDataSource().getConnection();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM utilisateur");
        stmt.executeUpdate("INSERT INTO `utilisateur`(utilisateur_id,utilisateur_mail,utilisateur_mdp) VALUES (1,'constance.salle@hei.fr','azerty')");
        stmt.executeUpdate("INSERT INTO `utilisateur`(utilisateur_id,utilisateur_mail,utilisateur_mdp) VALUES (2,'cesar.deligny@hei.fr','azerty2')");        stmt.close();
        connection.close();
    }

    @Test
    public void testerAjouterUtilisateur() throws Exception {
        Utilisateur utilisateur1 = new Utilisateur(null,"adresse@hei.fr", "azertyu");
        utilisateurDao.ajouterUtilisateur(utilisateur1);

        Connection connection = DataSourceProvider.getDataSource().getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM utilisateur WHERE utilisateur_mail = 'adresse@hei.fr'");
        Assert.assertTrue(resultSet.next());
        Assert.assertNotNull(resultSet.getLong("utilisateur_id"));
        Assert.assertEquals("adresse@hei.fr", resultSet.getString("utilisateur_mail"));
        Assert.assertEquals("azertyu", resultSet.getString("utilisateur_mdp"));
        Assert.assertFalse(resultSet.next());



        stmt.close();
        connection.close();
    }

}

