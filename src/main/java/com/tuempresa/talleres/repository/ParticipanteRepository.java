package com.tuempresa.talleres.repository;

import com.tuempresa.talleres.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    
    Optional<Participante> findByEmail(String email);
    
    List<Participante> findByNombreContainingIgnoreCase(String nombre);
    
    List<Participante> findByInstitucion(String institucion);
    
    boolean existsByEmail(String email);
}