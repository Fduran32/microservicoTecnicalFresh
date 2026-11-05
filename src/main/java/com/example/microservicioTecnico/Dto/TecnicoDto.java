package com.example.microservicioTecnico.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TecnicoDto {

    private Long id;
    private String nombre;
    private String cargo;
}
