package com.tuempresa.talleres.repository;

import com.tuempresa.talleres.model.Ponente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PonenteRepository extends JpaRepository<Ponente, Long> {
    
    Optional<Participante> findByEmail(String email);
    
    List<Participante> findByNombreContainingIgnoreCase(String nombre);
    
    List<Participante> findByEspecialidad(String especialidad);
    
    boolean existsByEmail(String email);
}