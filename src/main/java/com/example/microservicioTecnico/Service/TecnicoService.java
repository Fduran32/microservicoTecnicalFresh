package com.example.microservicioTecnico.Service;

import com.example.microservicioTecnico.Dto.TecnicoDto;
import com.example.microservicioTecnico.Model.TecnicoModel;
import com.example.microservicioTecnico.Repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TecnicoService {
@Autowired
    private  TecnicoRepository tecnicoRepository;


public TecnicoDto guardar (TecnicoDto dto){
    TecnicoModel model = new TecnicoModel(null, dto.getNombre(), dto.getCargo(), dto.getLocalAsignado());
            return toDto(tecnicoRepository.save(model));
}

public List<TecnicoDto>getAllTecnicos(){
    return tecnicoRepository.findAll().stream()
            .map(this::toDto)
            .toList();
}

public Boolean eliminarTecnico(Long id){
    if (tecnicoRepository.existsById(id)){
        tecnicoRepository.deleteById(id);
        return true;
    }
    return false;
}

private TecnicoDto toDto(TecnicoModel m){
    return new TecnicoDto(m.getId(), m.getNombre(), m.getCargo(), m.getLocalAsignado());
}
}
