package com.example.microservicioTecnico.Repository;


import com.example.microservicioTecnico.Model.ActivoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivoRepository extends JpaRepository<ActivoModel, Long> {
    Optional<ActivoModel> findByCodigoIgnoreCase(String codigo);

}
