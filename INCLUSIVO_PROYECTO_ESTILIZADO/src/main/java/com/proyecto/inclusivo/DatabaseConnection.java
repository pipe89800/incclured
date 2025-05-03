
package com.proyecto.inclusivo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/proyecto"; // Cambia 'tu_base_de_datos'
    private static final String USER = "root"; // Cambia 'tu_usuario'
    private static final String PASSWORD = "Angeles2026"; // Cambia 'tu_contraseña'

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return connection;
    }
}