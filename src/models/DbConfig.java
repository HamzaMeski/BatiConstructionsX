package models;

import java.sql.*;

public class DbConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/bati_constructions_x";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    private static final DbConfig instance = new DbConfig();

    private DbConfig() {
    }

    public static synchronized DbConfig getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
