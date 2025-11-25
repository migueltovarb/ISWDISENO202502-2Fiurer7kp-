package com.tuempresa.talleres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tuempresa.talleres.model.Certificado;
import com.tuempresa.talleres.service.CertificacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/certificaciones")
@CrossOrigin(origins = "*")
public class CertificacionController {

    @Autowired
    private CertificacionService certificacionService;

    @GetMapping
    public ResponseEntity<List<Certificado>> getAllCertificados() {
        List<Certificado> certificados = certificacionService.findAll();
        return ResponseEntity.ok(certificados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificado> getCertificadoById(@PathVariable Long id) {
        Optional<Certificado> certificado = certificacionService.findById(id);
        return certificado.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/participante/{participanteId}")
    public ResponseEntity<List<Certificado>> getCertificadosByParticipante(@PathVariable Long participanteId) {
        List<Certificado> certificados = certificacionService.findByParticipanteId(participanteId);
        return ResponseEntity.ok(certificados);
    }

    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<Certificado>> getCertificadosByEvento(@PathVariable Long eventoId) {
        List<Certificado> certificados = certificacionService.findByEventoId(eventoId);
        return ResponseEntity.ok(certificados);
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Certificado> getCertificadoByCodigo(@PathVariable String codigo) {
        Optional<Certificado> certificado = certificacionService.findByCodigo(codigo);
        return certificado.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Certificado> createCertificado(@RequestBody Certificado certificado) {
        try {
            Certificado savedCertificado = certificacionService.save(certificado);
            return ResponseEntity.ok(savedCertificado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertificado(@PathVariable Long id) {
        if (!certificacionService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        certificacionService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}