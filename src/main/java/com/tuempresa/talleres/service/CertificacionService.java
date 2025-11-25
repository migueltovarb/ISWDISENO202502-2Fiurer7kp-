package com.tuempresa.talleres.service;

import com.tuempresa.talleres.model.Certificado;
import com.tuempresa.talleres.repository.CertificadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Certificado> findById(Long id) {
        return certificadoRepository.findById(id);
    }

    public List<Certificado> findByParticipanteId(Long participanteId) {
        return certificadoRepository.findByParticipanteId(participanteId);
    }

    public List<Certificado> findByEventoId(Long eventoId) {
        return certificadoRepository.findByEventoId(eventoId);
    }

    public Certificado save(Certificado certificado) {
        return certificadoRepository.save(certificado);
    }

    public void deleteById(Long id) {
        certificadoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return certificadoRepository.existsById(id);
    }

    public Optional<Certificado> findByCodigo(String codigo) {
        return certificadoRepository.findByCodigo(codigo);
    }
}