package com.tuempresa.talleres.repository;

import com.tuempresa.talleres.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    
    List<Evento> findByEstado(String estado);
    
    List<Evento> findByFechaInicioBetween(LocalDateTime start, LocalDateTime end);
    
    List<Evento> findByNombreContainingIgnoreCase(String nombre);
    
    List<Evento> findByCapacidadMaximaGreaterThan(Integer capacidad);
    
    long countByEstado(String estado);
}