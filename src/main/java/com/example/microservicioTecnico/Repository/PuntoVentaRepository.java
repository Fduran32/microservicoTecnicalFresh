package com.example.microservicioTecnico.Repository;

import com.example.microservicioTecnico.Model.PuntoVentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntoVentaRepository  extends JpaRepository<PuntoVentaModel,Long> {
}
