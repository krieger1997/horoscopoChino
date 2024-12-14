package org.example.horoscopo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.horoscopo.Exception.AuthException;

import org.example.horoscopo.dto.UsuarioDTO;
import org.example.horoscopo.repository.HoroscopoRepositoryImpl;
import org.example.horoscopo.repository.UsuarioRepositoryImpl;
import org.example.horoscopo.service.UsuarioService;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    UsuarioService us;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.us = new UsuarioService(new UsuarioRepositoryImpl(), new HoroscopoRepositoryImpl());

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            UsuarioDTO usuario = us.autenticaUsuario(username, password);//ya viene con el animal desde aca.
            HttpSession session = req.getSession();
            session.setAttribute("user", usuario);
            req.getSession().setAttribute("user", usuario);
            resp.sendRedirect("/menu");
        } catch (AuthException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
        }

    }
}
