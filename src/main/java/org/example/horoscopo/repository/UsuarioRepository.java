package org.example.horoscopo.repository;

import org.example.horoscopo.modelo.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario getUserByUsername(String username);
    void saveUser(Usuario user);
    void deleteUser(int id);
    List<Usuario> getAllUsers();
    Usuario updateUser(Usuario user);
}
