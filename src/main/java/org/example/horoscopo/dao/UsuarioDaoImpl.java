package org.example.horoscopo.dao;

import org.example.horoscopo.modelo.Usuario;
import org.example.horoscopo.procesaConexion.DbConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class UsuarioDaoImpl implements UsuarioDao {
    Connection connection;

    public UsuarioDaoImpl() {
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
    public boolean saveUser(Usuario u) {
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
                return true;
            }else{
                return false;
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUser(int id) {
        try{
            String sql = "DELETE FROM USUARIOS WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario eliminado correctamente.");
                return true;
            }else{
                return false;
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
