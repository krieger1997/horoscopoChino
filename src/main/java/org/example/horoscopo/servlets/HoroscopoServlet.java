package org.example.horoscopo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.horoscopo.dao.HoroscopoDaoImpl;
import org.example.horoscopo.modelo.Horoscopo;
import org.example.horoscopo.modelo.Usuario;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HoroscopoServlet", value = "/horoscopo")
public class HoroscopoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            Usuario usuario = (Usuario) session.getAttribute("user");
            Horoscopo horoscopo = null;
            if (usuario != null) {
                List<Horoscopo> listaHoroscopo = new HoroscopoDaoImpl().getHoroscopo();
                for (Horoscopo horoscopoTemp : listaHoroscopo) {
                    if ((usuario.getFechaNacimiento().isAfter(horoscopoTemp.getFechaInicio()) && usuario.getFechaNacimiento().isBefore(horoscopoTemp.getFechaFin()))
                            || usuario.getFechaNacimiento().isEqual(horoscopoTemp.getFechaInicio())
                            || usuario.getFechaNacimiento().isEqual(horoscopoTemp.getFechaFin())) {
                        horoscopo = horoscopoTemp;
                    }


                }

            }


            req.setAttribute("horoscopo", horoscopo);
            req.getRequestDispatcher("view/horoscopo.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
