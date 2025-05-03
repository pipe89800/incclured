package com.proyecto.inclusivo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        try (Connection connection = DatabaseConnection.connect()) {
            if (connection == null) {
                throw new Exception("No se pudo establecer la conexión a la base de datos.");
            }

            String sql = "SELECT nombre FROM usuarios WHERE correo = ? AND contrasena = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, correo);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Si el usuario existe, guardar el nombre en la sesión
                String nombreUsuario = resultSet.getString("nombre");
                HttpSession session = request.getSession();
                session.setAttribute("nombre", nombreUsuario);

                // Redirigir a la página de bienvenida (asegúrate que el archivo exista en la ubicación correcta)
                response.sendRedirect("/bienvenida");
            } else {
                // Si el usuario no existe, redirigir de vuelta al login con un mensaje de error
                request.setAttribute("errorLogin", "Correo o contraseña incorrectos. Intenta de nuevo.");
                request.getRequestDispatcher("login.html").forward(request, response);
            }
        } catch (Exception e) {
             e.printStackTrace(); // Redirigir de vuelta al login con un mensaje de error
             request.setAttribute("errorLogin", "Error al iniciar sesión: " + e.getMessage());
             request.getRequestDispatcher("login.html").forward(request, response);
         }
    }
}

