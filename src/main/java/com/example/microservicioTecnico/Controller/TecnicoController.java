package com.example.microservicioTecnico.Controller;


import com.example.microservicioTecnico.Dto.TecnicoDto;
import com.example.microservicioTecnico.Service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tecnicos")
public class TecnicoController {
    @Autowired
    private TecnicoService tecnicoService;

    @PostMapping
    public TecnicoDto guardar(@RequestBody TecnicoDto dto){
        return tecnicoService.guardar(dto);
    }

    @GetMapping
    public List<TecnicoDto>getAll(){
        return tecnicoService.getAllTecnicos();
    }
    @DeleteMapping("/{id}")
    public String delete (@PathVariable Long id){
        return tecnicoService.eliminarTecnico(id)
                ?"tecnico eliminado "
                :"error al eliminar tecnico";
    }
}
