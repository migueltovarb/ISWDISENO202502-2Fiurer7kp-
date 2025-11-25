package com.tuempresa.talleres.repository;

import com.tuempresa.talleres.model.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Long> {
    
    List<Sesion> findByEventoId(Long eventoId);
    
    List<Sesion> findByPonenteId(Long ponenteId);
    
    List<Sesion> findByEstado(String estado);
}