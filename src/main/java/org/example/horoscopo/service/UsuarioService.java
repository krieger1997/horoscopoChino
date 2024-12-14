package org.example.horoscopo.service;

import org.example.horoscopo.Exception.AuthException;

import org.example.horoscopo.dto.UsuarioDTO;
import org.example.horoscopo.mapper.UsuarioMapper;
import org.example.horoscopo.modelo.Horoscopo;
import org.example.horoscopo.modelo.Usuario;
import org.example.horoscopo.repository.HoroscopoRepository;
import org.example.horoscopo.repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.List;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final HoroscopoRepository horoscopoRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, HoroscopoRepository horoscopoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.horoscopoRepository = horoscopoRepository;
    }

    public UsuarioDTO getUsuarioConHoroscopo(String username) {
        Usuario usuario = usuarioRepository.getUserByUsername(username);
        if (usuario != null) {
            Horoscopo horoscopo = calcularHoroscopo(usuario.getFechaNacimiento());
            usuario.setAnimal(horoscopo.getAnimal());
            return UsuarioMapper.toDTO(usuario);
        }
        return null;
    }

    public UsuarioDTO getUsuarioConHoroscopo(Usuario usuario) {
        if (usuario != null) {
            Horoscopo horoscopo = calcularHoroscopo(usuario.getFechaNacimiento());
            usuario.setAnimal(horoscopo.getAnimal());
            return UsuarioMapper.toDTO(usuario);
        }
        return null;
    }

    public Horoscopo calcularHoroscopo(LocalDate fechaNacimiento) {
        List<Horoscopo> listaHoroscopo = horoscopoRepository.getHoroscopoList();
        Horoscopo horoscopo = null;
        for (Horoscopo horoscopoTemp : listaHoroscopo) {
            if ((fechaNacimiento.isAfter(horoscopoTemp.getFechaInicio()) && fechaNacimiento.isBefore(horoscopoTemp.getFechaFin()))
                    || fechaNacimiento.isEqual(horoscopoTemp.getFechaInicio())
                    || fechaNacimiento.isEqual(horoscopoTemp.getFechaFin())) {
                horoscopo = horoscopoTemp;
            }


        }
        return horoscopo;
    }


    public UsuarioDTO autenticaUsuario(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            throw new AuthException("Todos los campos son obligatorios.");
        }
        try{
            Usuario usuario = usuarioRepository.getUserByUsername(username);
            if (usuario == null) {
                System.out.println("USUARIO NO EXISTE");
                throw new AuthException("Usuario no existe, debe registrarse.");
            } else {
                if (usuario.getPassword().equals(password)) {
                    return getUsuarioConHoroscopo(usuario);
                } else {
                    System.out.println("CONTRASEÑA INCORRECTA");
                    throw new AuthException("Contraseña incorrecta.");
                }
            }

        }catch (RuntimeException e){
            throw new AuthException(e.getMessage());
        }

    }

    public void registraUsuario(String name, String username, String email, String fechaNacimiento, String password, String rePassword){

        if (name.isEmpty() || username.isEmpty() || email.isEmpty() || fechaNacimiento.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            throw new RuntimeException("Todos los campos son obligatorios");
        } else if (!password.equals(rePassword)) {
            throw new RuntimeException("Contraseña no es igual.");
        } else {
            LocalDate fechaNacimientoDate = LocalDate.parse(fechaNacimiento);
            Usuario usuario = new Usuario(name, username, email, fechaNacimientoDate, password);
            usuarioRepository.saveUser(usuario);
        }
    }

    public void eliminaUsuario(int id){
        try {
            usuarioRepository.deleteUser(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public List<UsuarioDTO> listaUsuarios(){
        return UsuarioMapper.toDTOList(usuarioRepository.getAllUsers());
    }

    public UsuarioDTO actualizaUsuario(UsuarioDTO dto){
        try {
            usuarioRepository.updateUser(UsuarioMapper.fromDTO(dto));
            Horoscopo horoscopo = calcularHoroscopo(dto.getFechaNacimiento());
            dto.setAnimal(horoscopo.getAnimal());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
