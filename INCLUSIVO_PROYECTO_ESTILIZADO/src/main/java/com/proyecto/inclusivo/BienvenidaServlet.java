package com.proyecto.inclusivo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bienvenida")
public class BienvenidaServlet extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String nombreUsuario = (String) session.getAttribute("nombre");

        request.setAttribute("nombreUsuario", nombreUsuario); // Establece el nombre como atributo
        request.getRequestDispatcher("bienvenido.jsp").forward(request, response); // Reenvía al JSP
    }
}