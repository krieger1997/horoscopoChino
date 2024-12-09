package org.example.horoscopo.dao;

import org.example.horoscopo.modelo.Usuario;

public interface UsuarioDao {



    public Usuario getUserByUsername(String username);
    public boolean saveUser(Usuario user);
    public boolean deleteUser(int id);
}
