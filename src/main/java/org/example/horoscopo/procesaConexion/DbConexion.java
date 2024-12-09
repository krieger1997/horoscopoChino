package org.example.horoscopo.procesaConexion;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConexion {
    private static DbConexion instance;
    private Connection connection;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


    private DbConexion() {
        try {
            Dotenv env = Dotenv.load();

            String url = env.get("DB_URL");
            String user = env.get("DB_USER");
            String password = env.get("DB_PASSWORD");
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
            throw new RuntimeException("ERROR AL CONECTAR A AL BD: " + e);
        }
    }

    public static DbConexion getInstance() {
        if (instance == null) {
            instance = new DbConexion();
        }
        return instance;
    }
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                getInstance();
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting database connection ", e);
        }
    }

    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new RuntimeException("ERROR AL CERRAR LA CONEXION A LA BD: " + e);
        }

    }
}
