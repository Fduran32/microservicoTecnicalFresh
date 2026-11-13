package com.example.microservicioTecnico.Service;

import com.example.microservicioTecnico.Dto.PuntoVentaDto;
import com.example.microservicioTecnico.Model.PuntoVentaModel;
import com.example.microservicioTecnico.Repository.PuntoVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoVentaService {
    @Autowired
    private PuntoVentaRepository puntoVentaRepository;

    public PuntoVentaDto guardar(PuntoVentaDto dto) {
        PuntoVentaModel model = new PuntoVentaModel(
                null,
                dto.getNombre(),
                dto.getDireccion(),
                dto.getComuna(),
                dto.getLatitud(),
                dto.getLongitud()
        );
        return toDto(puntoVentaRepository.save(model));
    }

    public List<PuntoVentaDto> getAllPuntosVenta() {
        return puntoVentaRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    private PuntoVentaDto toDto(PuntoVentaModel m) {
        return new PuntoVentaDto(m.getId(), m.getNombre(), m.getDireccion(), m.getComuna(), m.getLatitud(), m.getLongitud());
    }
}