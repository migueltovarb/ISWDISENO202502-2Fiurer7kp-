package com.tuempresa.talleres.repository;

import com.tuempresa.talleres.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    
    List<Pago> findByInscripcionId(Long inscripcionId);
    
    List<Pago> findByEstado(String estado);
    
    List<Pago> findByInscripcionParticipanteId(Long participanteId);
    
    Optional<Pago> findByCodigoTransaccion(String codigoTransaccion);
}