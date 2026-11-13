package com.example.microservicioTecnico.Controller;

import com.example.microservicioTecnico.Dto.PuntoVentaDto;
import com.example.microservicioTecnico.Service.PuntoVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/puntos-venta")
public class PuntoVentaController {
    @Autowired
    private PuntoVentaService puntoVentaService;

    @GetMapping
    public List<PuntoVentaDto> getAll() {
        return puntoVentaService.getAllPuntosVenta();
    }

    @PostMapping
    public PuntoVentaDto guardar(@RequestBody PuntoVentaDto dto) {
        return puntoVentaService.guardar(dto);
    }
}
