package com.example.max.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//���������� � ����� ������
public class ConnectionsUtils {

    private static final String DB_PROP = "db.properties";
    private static final String DB_PROP_2 = "db_2.properties";
    private static final String USE_DB = "use_db.properties";

    //������������� ����������
    public static Connection getConnection() {

        Connection con = null;

        try {

            PropertiesConfiguration config= getPropConfig(USE_DB);

            if (config != null) {

                String dbName = config.getString("db.name");

                if(dbName.equals("departments")){
                    config= getPropConfig(DB_PROP);
                }
                if(dbName.equals("departments4")){
                    config= getPropConfig(DB_PROP_2);
                }

                Class.forName(config.getString("db.driver"));

                con = DriverManager.getConnection(
                        config.getString("db.url"),
                        config.getString("db.employee"),
                        config.getString("db.password"));
            }

        } catch (SQLException sqe) {
            System.out.println(sqe);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    //�������� �����
    public static void close(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ignored) {
        }
    }


    public static PropertiesConfiguration getPropConfig(String configFileName){
        PropertiesConfiguration config = null;
        try {
            config = new PropertiesConfiguration(configFileName);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return config;
    }


}
