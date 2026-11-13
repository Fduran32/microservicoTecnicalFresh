package com.example.microservicioTecnico.Service;

import com.example.microservicioTecnico.Dto.UsuarioDto;
import com.example.microservicioTecnico.Model.UsuarioModel;
import com.example.microservicioTecnico.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDto registrar(UsuarioDto dto) {
        String correoLimpio = dto.getCorreo().trim().toLowerCase();
        if (usuarioRepository.findByCorreoIgnoreCase(correoLimpio).isPresent()) {
            return null; // Ya existe una cuenta con ese correo
        }
        UsuarioModel model = new UsuarioModel(
                null,
                dto.getNombre().trim(),
                correoLimpio,
                dto.getClaveHash(),
                dto.getRol(),
                dto.getCargo()
        );
        return toDto(usuarioRepository.save(model));
    }

    public UsuarioDto login(UsuarioDto dto) {
        Optional<UsuarioModel> encontrado = usuarioRepository.findByCorreoIgnoreCase(dto.getCorreo().trim());
        if (encontrado.isPresent() && encontrado.get().getClaveHash().equals(dto.getClaveHash())) {
            return toDto(encontrado.get());
        }
        return null;
    }

    public List<UsuarioDto> getUsuarios(String rol) {
        List<UsuarioModel> lista = (rol != null && !rol.isBlank())
                ? usuarioRepository.findByRolOrderByNombreAsc(rol)
                : usuarioRepository.findAll();
        return lista.stream().map(this::toDto).toList();
    }

    private UsuarioDto toDto(UsuarioModel m) {
        return new UsuarioDto(m.getId(), m.getNombre(), m.getCorreo(), m.getClaveHash(), m.getRol(), m.getCargo());
    }
}