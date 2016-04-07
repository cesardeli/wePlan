package hei.devweb.evenement.daos;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {

    private static MysqlDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setPort(8889); //pour Constance 3306
            dataSource.setDatabaseName("we_plan");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        }
        return dataSource;
    }
}
