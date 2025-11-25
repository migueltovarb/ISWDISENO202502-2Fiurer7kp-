package com.tuempresa.talleres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tuempresa.talleres.dto.InscriptionRequest;
import com.tuempresa.talleres.dto.InscriptionResponse;
import com.tuempresa.talleres.model.Inscription;
import com.tuempresa.talleres.service.InscriptionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inscripciones")
@CrossOrigin(origins = "*")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping
    public ResponseEntity<List<InscriptionResponse>> getAllInscripciones() {
        List<Inscription> inscripciones = inscriptionService.findAll();
        List<InscriptionResponse> response = inscripciones.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionResponse> getInscripcionById(@PathVariable Long id) {
        return inscriptionService.findById(id)
                .map(this::convertToResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<InscriptionResponse>> getInscripcionesByEvento(@PathVariable Long eventoId) {
        List<Inscription> inscripciones = inscriptionService.findByEventoId(eventoId);
        List<InscriptionResponse> response = inscripciones.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/participante/{participanteId}")
    public ResponseEntity<List<InscriptionResponse>> getInscripcionesByParticipante(@PathVariable Long participanteId) {
        List<Inscription> inscripciones = inscriptionService.findByParticipanteId(participanteId);
        List<InscriptionResponse> response = inscripciones.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<InscriptionResponse> createInscripcion(@RequestBody InscriptionRequest request) {
        try {
            Inscription inscripcion = new Inscription();
            inscripcion.setEventoId(request.getEventoId());
            inscripcion.setParticipanteId(request.getParticipanteId());
            inscripcion.setTipoInscripcion(request.getTipoInscripcion());
            inscripcion.setObservaciones(request.getObservaciones());
            inscripcion.setEstado("PENDIENTE");

            Inscription savedInscripcion = inscriptionService.save(inscripcion);
            return ResponseEntity.ok(convertToResponse(savedInscripcion));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<InscriptionResponse> updateEstadoInscripcion(
            @PathVariable Long id, 
            @RequestParam String estado) {
        return inscriptionService.findById(id)
                .map(inscripcion -> {
                    inscripcion.setEstado(estado);
                    Inscription updatedInscripcion = inscriptionService.save(inscripcion);
                    return ResponseEntity.ok(convertToResponse(updatedInscripcion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscripcion(@PathVariable Long id) {
        if (!inscriptionService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        inscriptionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private InscriptionResponse convertToResponse(Inscription inscripcion) {
        InscriptionResponse response = new InscriptionResponse();
        response.setId(inscripcion.getId());
        response.setEventoId(inscripcion.getEventoId());
        response.setParticipanteId(inscripcion.getParticipanteId());
        response.setEstado(inscripcion.getEstado());
        response.setTipoInscripcion(inscripcion.getTipoInscripcion());
        response.setObservaciones(inscripcion.getObservaciones());
        response.setFechaInscripcion(inscripcion.getFechaInscripcion());
        return response;
    }
}