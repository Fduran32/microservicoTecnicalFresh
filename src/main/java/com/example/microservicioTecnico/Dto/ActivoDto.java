package com.example.microservicioTecnico.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivoDto {
    private Long id;
    private String codigo;
    private String tipo;
    private String marca;
    private String modelo;
    private Long puntoVentaId;
}