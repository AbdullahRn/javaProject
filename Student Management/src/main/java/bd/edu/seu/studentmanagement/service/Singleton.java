package bd.edu.seu.studentmanagement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    public static final String DB_HOST = "localhost";
    public static final String DB_NAME = "stdmgtdb";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "AbdullahR745";
    public static final String DB_URL = "jdbc:mysql://" + DB_HOST + "/" + DB_NAME;

    private static Connection connection;
    private static Singleton  singletone = new Singleton();
    private Singleton() {
        try{
            connection = DriverManager.getConnection(Singleton.DB_URL, Singleton.DB_USERNAME, Singleton.DB_PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
