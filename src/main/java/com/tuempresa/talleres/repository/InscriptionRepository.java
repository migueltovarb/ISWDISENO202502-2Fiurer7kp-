package com.tuempresa.talleres.repository;

import com.tuempresa.talleres.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    
    List<Inscription> findByEventoId(Long eventoId);
    
    List<Inscription> findByParticipanteId(Long participanteId);
    
    Optional<Inscription> findByEventoIdAndParticipanteId(Long eventoId, Long participanteId);
    
    List<Inscription> findByEstado(String estado);
    
    long countByEventoId(Long eventoId);
    
    long countByEventoIdAndEstado(Long eventoId, String estado);
    
    boolean existsByEventoIdAndParticipanteId(Long eventoId, Long participanteId);
}