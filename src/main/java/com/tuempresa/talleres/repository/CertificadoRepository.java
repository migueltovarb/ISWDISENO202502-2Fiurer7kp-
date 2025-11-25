package com.tuempresa.talleres.repository;

import com.tuempresa.talleres.model.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {

    List<Certificado> findByParticipanteId(Long participanteId);

    List<Certificado> findByEventoId(Long eventoId);

    @Query("SELECT c FROM Certificado c WHERE c.codigoVerificacion = :codigo")
    Optional<Certificado> findByCodigo(@Param("codigo") String codigo);
}
