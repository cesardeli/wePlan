package hei.devweb.evenement.daos;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceProvider {

	private static MysqlDataSource dataSource;

	public static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPort(8080); //juste pour César, sinon 8081
			dataSource.setDatabaseName("we_plan");
			dataSource.setUser("root");
			dataSource.setPassword("root");
		}
		return dataSource;
	}
}
