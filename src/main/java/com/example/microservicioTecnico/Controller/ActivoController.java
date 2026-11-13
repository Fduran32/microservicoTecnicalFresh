package com.example.microservicioTecnico.Controller;

import com.example.microservicioTecnico.Dto.ActivoDto;
import com.example.microservicioTecnico.Service.ActivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activos")
public class ActivoController {
    @Autowired
    private ActivoService activoService;

    @GetMapping
    public List<ActivoDto> getAll() {
        return activoService.getAllActivos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivoDto> getPorId(@PathVariable Long id) {
        ActivoDto dto = activoService.getPorId(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ActivoDto> getPorCodigo(@PathVariable String codigo) {
        ActivoDto dto = activoService.getPorCodigo(codigo);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ActivoDto guardar(@RequestBody ActivoDto dto) {
        return activoService.guardar(dto);
    }
}
