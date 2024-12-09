package org.example.horoscopo.modelo;

import java.time.LocalDate;

public class Usuario {

    private String nombre;
    private String username;
    private String email;
    private LocalDate fechaNacimiento;
    private String password;
    private int id;


    public Usuario() {
    }

    public Usuario(String nombre, String username, String email, LocalDate fechaNacimiento, String password) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;


    }
    public Usuario(String nombre, String username, String email, LocalDate fechaNacimiento, String password, int id) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.id = id;

    }

    public String getNombre() {
        return nombre;
    }
    public String getNombreCap(){
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
