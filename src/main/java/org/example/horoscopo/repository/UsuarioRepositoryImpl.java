package org.example.horoscopo.repository;

import org.example.horoscopo.modelo.Usuario;
import org.example.horoscopo.procesaConexion.DbConexion;
import org.example.horoscopo.service.UsuarioService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    Connection connection;

    public UsuarioRepositoryImpl() {
        connection = DbConexion.getInstance().getConnection();
    }

    @Override
    public Usuario getUserByUsername(String username) {
        try {
            String sql = "SELECT * FROM USUARIOS WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return new Usuario(
                        resultSet.getString("nombre"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        LocalDate.parse(resultSet.getString("fecha_nacimiento")),
                        resultSet.getString("password"),
                        resultSet.getInt("id")
                );
            }else{
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(Usuario u) {
        try{
            String sql = "INSERT INTO USUARIOS (nombre, username, email, fecha_nacimiento, password) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, u.getNombre());
            statement.setString(2, u.getUsername());
            statement.setString(3, u.getEmail());
            statement.setString(4, String.valueOf(u.getFechaNacimiento()));
            statement.setString(5, u.getPassword());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario registrado correctamente.");

            }else{
                throw new RuntimeException("Error al insertar el usuario.");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(int id) {
        try{
            String sql = "DELETE FROM USUARIOS WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario eliminado correctamente.");

            }else{
                throw new RuntimeException("Error al eliminar el usuario.");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Usuario> getAllUsers() {
        try{
            UsuarioService us = new UsuarioService(this, new HoroscopoRepositoryImpl());
            String sql = "SELECT * FROM USUARIOS;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Usuario> listaUsuarios = new ArrayList<>();
            while(resultSet.next()){
                Usuario u = new Usuario(
                        resultSet.getString("nombre"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        LocalDate.parse(resultSet.getString("fecha_nacimiento")),
                        resultSet.getString("password"),
                        resultSet.getInt("id")
                );
                u.setAnimal(us.calcularHoroscopo(u.getFechaNacimiento()).getAnimal());
                listaUsuarios.add(u);
            }
            return listaUsuarios;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public Usuario updateUser(Usuario u) {
        try{
            String sql = "UPDATE USUARIOS SET nombre=?, username=?, email=?, fecha_nacimiento=? WHERE id=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, u.getNombre());
            statement.setString(2, u.getUsername());
            statement.setString(3, u.getEmail());
            statement.setString(4, String.valueOf(u.getFechaNacimiento()));
            statement.setInt(5, u.getId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario ACTUALIZADO correctamente.");
                return u;
            }else{
                throw new RuntimeException("Error al actualizar el usuario.");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
