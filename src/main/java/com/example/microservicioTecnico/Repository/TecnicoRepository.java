package com.example.microservicioTecnico.Repository;


import com.example.microservicioTecnico.Model.TecnicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository  extends JpaRepository <TecnicoModel, Long>{
}
