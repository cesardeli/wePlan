package hei.devweb.evenement.daos;

import hei.devweb.evenement.entites.Evenement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import java.sql.Connection;

public class EvenementDaoTestCase {

    private EvenementDao evenementDao = new EvenementDaoImpl();

    @Before
    public void initBdd() throws Exception {
        Connection connection = DataSourceProvider.getDataSource().getConnection();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM evenement");
        stmt.executeUpdate("INSERT INTO `evenement`(evenement_id,evenement_nom,evenement_lieu,evenement_prive, evenement_date_debut, evenement_date_fin, evenement_description) VALUES (1,'Universelle','Belgique',true, '2016-02-11', '2016-02-12', 'La plus grosse soiree de HEI')");
        stmt.executeUpdate("INSERT INTO `evenement`(evenement_id,evenement_nom,evenement_lieu,evenement_prive, evenement_description) VALUES (2,'Test2','Belgique',false,'description2')");
        stmt.close();
        connection.close();
    }

    @Test
    public void testerListerEvenements() {
        List<Evenement> evenements = evenementDao.listerEvenements();
        Assert.assertEquals(2, evenements.size());
        Assert.assertEquals(1L, evenements.get(0).getEvenement_id().longValue());
        Assert.assertEquals("Universelle", evenements.get(0).getEvenement_nom());
        Assert.assertEquals("Belgique", evenements.get(0).getEvenement_lieu());
        Assert.assertEquals(true, evenements.get(0).getEvenement_prive());
        //Assert.assertEquals(new Date(2016-02-11), evenements.get(0).getEvenement_date_debut());
        Assert.assertEquals("La plus grosse soiree de HEI", evenements.get(0).getEvenement_description());
    }


    @Test
    public void testerSupprimerEvenement() throws Exception {

        evenementDao.supprimerEvenement(1);

        List<Evenement> evenements = evenementDao.listerEvenements();
        Assert.assertEquals(1, evenements.size());
    }


    @Test
    public void testerAjouterEvenement() throws Exception {
        Evenement evenement3 = new Evenement(null, "nom3", "lieu3", false, new Date(2016 - 03 - 13), null, new Date(2016 - 03 - 14), null, "description3");
        evenementDao.ajouterEvenement(evenement3);

        Connection connection = DataSourceProvider.getDataSource().getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM evenement WHERE evenement_nom = 'nom3'");
        Assert.assertTrue(resultSet.next());
        Assert.assertNotNull(resultSet.getLong("evenement_id"));
        Assert.assertEquals("nom3", resultSet.getString("evenement_nom"));
        Assert.assertEquals("lieu3", resultSet.getString("evenement_lieu"));
        Assert.assertEquals(false, resultSet.getBoolean("evenement_prive"));
        Assert.assertEquals("description3", resultSet.getString("evenement_description"));
        Assert.assertFalse(resultSet.next());

        List<Evenement> evenements = evenementDao.listerEvenements();
        Assert.assertEquals(3, evenements.size());

        stmt.close();
        connection.close();
    }


    @Test
    public void testerModifierEvenement() throws Exception {
        Evenement evenement4 = new Evenement(2, "nom4", "lieu4", true, null, null, null, null, "description4");
        evenementDao.modifierEvenement(evenement4);
        Connection connection = DataSourceProvider.getDataSource().getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM evenement WHERE evenement_id = 2");
        Assert.assertTrue(resultSet.next());

        Assert.assertNotNull(resultSet.getLong("evenement_id"));
        Assert.assertEquals("nom4", resultSet.getString("evenement_nom"));
        Assert.assertEquals("lieu4", resultSet.getString("evenement_lieu"));
        Assert.assertEquals(true, resultSet.getBoolean("evenement_prive"));
        Assert.assertEquals("description4", resultSet.getString("evenement_description"));

        Assert.assertFalse(resultSet.next());

        stmt.close();
        connection.close();
    }


}
