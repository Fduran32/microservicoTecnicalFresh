package com.example.microservicioTecnico.Service;

import com.example.microservicioTecnico.Dto.ActivoDto;
import com.example.microservicioTecnico.Model.ActivoModel;
import com.example.microservicioTecnico.Repository.ActivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivoService {
    @Autowired
    private ActivoRepository activoRepository;

    public ActivoDto guardar(ActivoDto dto) {
        ActivoModel model = new ActivoModel(
                null,
                dto.getCodigo().trim().toUpperCase(),
                dto.getTipo(),
                dto.getMarca(),
                dto.getModelo(),
                dto.getPuntoVentaId()
        );
        return toDto(activoRepository.save(model));
    }

    public List<ActivoDto> getAllActivos() {
        return activoRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public ActivoDto getPorId(Long id) {
        return activoRepository.findById(id).map(this::toDto).orElse(null);
    }

    public ActivoDto getPorCodigo(String codigo) {
        return activoRepository.findByCodigoIgnoreCase(codigo.trim()).map(this::toDto).orElse(null);
    }

    private ActivoDto toDto(ActivoModel m) {
        return new ActivoDto(m.getId(), m.getCodigo(), m.getTipo(), m.getMarca(), m.getModelo(), m.getPuntoVentaId());
    }
}