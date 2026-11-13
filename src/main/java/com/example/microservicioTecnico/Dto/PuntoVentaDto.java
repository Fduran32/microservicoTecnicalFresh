package com.example.microservicioTecnico.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PuntoVentaDto {
    private Long id;
    private String nombre;
    private String direccion;
    private String comuna;
    private Double latitud;
    private Double longitud;
}