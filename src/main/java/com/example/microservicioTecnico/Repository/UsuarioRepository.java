package com.example.microservicioTecnico.Repository;

import com.example.microservicioTecnico.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByCorreoIgnoreCase(String correo);
    List<UsuarioModel> findByRolOrderByNombreAsc(String rol);
}
