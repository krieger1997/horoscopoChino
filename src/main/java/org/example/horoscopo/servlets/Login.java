package org.example.horoscopo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.horoscopo.dao.UsuarioDao;
import org.example.horoscopo.dao.UsuarioDaoImpl;
import org.example.horoscopo.modelo.Usuario;

import java.io.IOException;

@WebServlet(name="login", value="/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UsuarioDao dao = new UsuarioDaoImpl();
        Usuario usuario = dao.getUserByUsername(username);
        if(usuario == null){
            req.setAttribute("error", "Usuario no existe, debe registrarse");
            System.out.println(req.getAttribute("error"));
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
        }else{
            if (usuario.getPassword().equals(password)) {

                HttpSession session = req.getSession();
                session.setAttribute("user", usuario);
                req.getSession().setAttribute("user", usuario);
                resp.sendRedirect("/menu");

            } else {
                req.setAttribute("error", "Contraseña incorrecta");
                System.out.println(req.getAttribute("error"));

                req.getRequestDispatcher("view/login.jsp").forward(req, resp);
            }

        }
    }
}
