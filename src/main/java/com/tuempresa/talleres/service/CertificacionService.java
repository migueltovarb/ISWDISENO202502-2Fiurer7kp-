package com.tuempresa.talleres.service;

import com.tuempresa.talleres.model.Certificado;
import com.tuempresa.talleres.repository.CertificadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificacionService {

    @Autowired
    private CertificadoRepository certificadoRepository;

    public List<Certificado> findAll() {
        return certificadoRepository.findAll();
    }

    public Optional<Certificado> findById(@Nullable Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return certificadoRepository.findById(id);
    }

    public List<Certificado> findByParticipanteId(Long participanteId) {
        return certificadoRepository.findByParticipanteId(participanteId);
    }

    public List<Certificado> findByEventoId(Long eventoId) {
        return certificadoRepository.findByEventoId(eventoId);
    }

    public Certificado save(@Nullable Certificado certificado) {
        if (certificado == null) {
            throw new IllegalArgumentException("Certificado no puede ser null");
        }
        return certificadoRepository.save(certificado);
    }

    public void deleteById(@Nullable Long id) {
        if (id != null) {
            certificadoRepository.deleteById(id);
        }
    }

    public boolean existsById(@Nullable Long id) {
        if (id == null) {
            return false;
        }
        return certificadoRepository.existsById(id);
    }

    public Optional<Certificado> findByCodigo(String codigo) {
        return certificadoRepository.findByCodigo(codigo);
    }
}