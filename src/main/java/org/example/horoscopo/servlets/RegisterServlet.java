package org.example.horoscopo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.horoscopo.dao.UsuarioDao;
import org.example.horoscopo.dao.UsuarioDaoImpl;
import org.example.horoscopo.modelo.Usuario;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/register.jsp").forward(req, resp);;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("rePassword");

        if (name.isEmpty() || username.isEmpty() || email.isEmpty() || fechaNacimiento.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            req.setAttribute("error", "Todos los campos son obligatorios");
            System.out.println(req.getAttribute("error"));
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
        } else if (!password.equals(rePassword)) {
            req.setAttribute("error", "Contraseña no es igual.");
            System.out.println(req.getAttribute("error"));
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
        } else {
            LocalDate fechaNacimientoDate = LocalDate.parse(fechaNacimiento);
            UsuarioDao usuarioDao = new UsuarioDaoImpl();

            boolean result = usuarioDao.saveUser( new Usuario(name, username, email, fechaNacimientoDate, password));
            if(result){
                req.setAttribute("success", "Usuario registrado exitosamente.");
                req.getRequestDispatcher("view/login.jsp").forward(req, resp);

            }


        }

    }
}
