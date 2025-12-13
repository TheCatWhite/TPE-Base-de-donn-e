package com.gestionprojet.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {
    private static final String URL ="jdbc:postgresql://localhost:5432/gestion_projet";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Ryan";

    private DatabaseConnection() {
    }
    
    /**
     * @return Connection
     * @throws SQLException
    */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}