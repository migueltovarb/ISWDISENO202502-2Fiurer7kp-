package com.tuempresa.talleres.repository;

import com.tuempresa.talleres.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    
    List<Pago> findByInscriptionId(Long inscriptionId);
    
    List<Pago> findByEstado(String estado);
    
    List<Pago> findByParticipanteId(Long participanteId);
    
    Optional<Pago> findByCodigoTransaccion(String codigoTransaccion);
}