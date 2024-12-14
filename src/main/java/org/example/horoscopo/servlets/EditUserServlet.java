package org.example.horoscopo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.horoscopo.dto.UsuarioDTO;
import org.example.horoscopo.repository.HoroscopoRepositoryImpl;
import org.example.horoscopo.repository.UsuarioRepositoryImpl;
import org.example.horoscopo.service.UsuarioService;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="EditUserServlet", value="/editUser")
public class EditUserServlet extends HttpServlet {
    UsuarioService us;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.us = new UsuarioService(new UsuarioRepositoryImpl(), new HoroscopoRepositoryImpl());

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String fechaNacimiento = req.getParameter("fechaNacimiento");

        UsuarioDTO user = (UsuarioDTO) req.getSession().getAttribute("user");
        user.setNombre(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setFechaNacimiento(LocalDate.parse(fechaNacimiento));

        try {
            UsuarioDTO userUpdated = this.us.actualizaUsuario(user);
            req.setAttribute("success", "Usuario actualizado exitosamente.");
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            req.getRequestDispatcher("view/edit.jsp").forward(req, resp);
        } catch (RuntimeException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("view/edit.jsp").forward(req, resp);
        }


    }
}
