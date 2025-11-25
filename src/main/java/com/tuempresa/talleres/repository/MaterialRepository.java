package com.tuempresa.talleres.repository;

import com.tuempresa.talleres.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    
    List<Material> findByEventoId(Long eventoId);
    
    List<Material> findByTipo(String tipo);
    
    List<Material> findByNombreContainingIgnoreCase(String nombre);
}