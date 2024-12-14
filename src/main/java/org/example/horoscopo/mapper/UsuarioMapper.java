package org.example.horoscopo.mapper;

import org.example.horoscopo.dto.UsuarioDTO;
import org.example.horoscopo.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {
    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsername(usuario.getUsername());
        dto.setEmail(usuario.getEmail());
        dto.setNombre(usuario.getNombre());
        dto.setFechaNacimiento(usuario.getFechaNacimiento());
        dto.setAnimal(usuario.getAnimal());
        dto.setId(usuario.getId());
        return dto;
    }

    public static Usuario fromDTO(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setNombre(dto.getNombre());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setAnimal(dto.getAnimal());
        usuario.setId(dto.getId());
        return usuario;
    }

    public static List<UsuarioDTO> toDTOList(List<Usuario> usuarios) {
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioDTOS.add(toDTO(usuario));
        }
        return usuarioDTOS;
    }
}
