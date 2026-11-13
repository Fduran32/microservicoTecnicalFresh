package com.example.microservicioTecnico.Controller;

import com.example.microservicioTecnico.Dto.UsuarioDto;
import com.example.microservicioTecnico.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDto> registrar(@RequestBody UsuarioDto dto) {
        UsuarioDto creado = usuarioService.registrar(dto);
        if (creado == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(creado);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> login(@RequestBody UsuarioDto dto) {
        UsuarioDto autenticado = usuarioService.login(dto);
        if (autenticado == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(autenticado);
    }

    @GetMapping
    public List<UsuarioDto> getAll(@RequestParam(required = false) String rol) {
        return usuarioService.getUsuarios(rol);
    }
}
