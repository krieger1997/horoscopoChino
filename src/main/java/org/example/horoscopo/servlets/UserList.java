package org.example.horoscopo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.horoscopo.dto.UsuarioDTO;
import org.example.horoscopo.repository.HoroscopoRepositoryImpl;
import org.example.horoscopo.repository.UsuarioRepositoryImpl;
import org.example.horoscopo.service.UsuarioService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserList", value = "/userList")
public class UserList extends HttpServlet {
    UsuarioService us;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.us = new UsuarioService(new UsuarioRepositoryImpl(), new HoroscopoRepositoryImpl());
        try {
            List<UsuarioDTO> userList = us.listaUsuarios();
            req.setAttribute("userList", userList);
            req.getRequestDispatcher("view/userList.jsp").forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("view/menu.jsp").forward(req, resp);
        }


    }
}
