package hei.devweb.evenement.daos;
	
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	
	
	import hei.devweb.evenement.entites.Utilisateur;
	
	public  class UtilisateurDaoImpl implements UtilisateurDao {
	
		public Utilisateur getUtilisateur(Integer utilisateur_id) {
		
			Utilisateur utilisateur1 = new Utilisateur((Integer) null, null, null);
	
			try {
				Connection connection = DataSourceProvider.getDataSource().getConnection();
				
				Statement stmt = connection.createStatement();
				ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur WHERE");
				while(results.next()) {
					utilisateur1.setUtilisateur_id(results.getInt("utilisateur_id"));
					utilisateur1.setUtilisateur_mail(results.getString("utilisateur_mail"));
					utilisateur1.setUtilisateur_mdp(results.getString("utilisateur_mdp"));
				}
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			return utilisateur1;
		}
	
		public boolean verifierUtilisateur(String utilisateur_mail, String utilisateur_mdp) {
	
			String motdepasseUtilisateur = "";
			
			try {
				Connection connection = DataSourceProvider.getDataSource().getConnection();
				
				Statement stmt = connection.createStatement();
				ResultSet results = stmt.executeQuery("SELECT utilisateur_mdp FROM utilisateur WHERE utilisateur_id = '"+utilisateur_mail+"'");
				while (results.next()) {
					motdepasseUtilisateur = results.getString("utilisateur_mdp");
				}	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(motdepasseUtilisateur != ""){	
				if(motdepasseUtilisateur.equals(utilisateur_mdp)) {
					return true;
				} 
			}
			return false;
		}
	}