package org.example.horoscopo.repository;

import org.example.horoscopo.modelo.Horoscopo;

import java.util.List;

public interface HoroscopoRepository {
    List<Horoscopo> getHoroscopoList();
}
