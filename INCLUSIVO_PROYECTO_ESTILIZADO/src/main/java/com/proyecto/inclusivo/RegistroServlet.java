
package com.proyecto.inclusivo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String edad = request.getParameter("edad");
        String nivelCognitivo = request.getParameter("nivel_cognitivo");
        String progreso = request.getParameter("progreso");
        String contrasena = request.getParameter("contrasena");// Asegúrate de capturar el nombre

        try (Connection connection = DatabaseConnection.connect()) {
            if (connection == null) {
                throw new Exception("No se pudo establecer la conexión a la base de datos.");
            }

            // Ajusta la consulta para incluir el campo 'nombre'
            String sql = "INSERT INTO usuarios (nombre, correo, edad, nivel_cognitivo, progreso, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, correo);
            statement.setString(3, edad);
            statement.setString(4, nivelCognitivo);
            statement.setString(5, progreso);
            statement.setString(6, contrasena); 
            statement.executeUpdate();

            response.sendRedirect("index.html");
        } catch (Exception e) {
            e.printStackTrace(); 
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Error al registrar: " + e.getMessage() + "</h2>");
        }
    }
}