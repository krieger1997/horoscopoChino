package org.example.horoscopo.dao;

import org.example.horoscopo.modelo.Horoscopo;

import java.time.LocalDate;
import java.util.List;

public interface HoroscopoDao {

    public List<Horoscopo> getHoroscopo();
}
