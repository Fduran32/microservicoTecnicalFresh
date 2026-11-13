package com.example.microservicioTecnico.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String correo;
    private String claveHash;
    private String rol;
    private String cargo;
}