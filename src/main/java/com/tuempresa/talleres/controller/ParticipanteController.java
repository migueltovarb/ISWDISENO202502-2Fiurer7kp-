package com.tuempresa.talleres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tuempresa.talleres.model.Participante;
import com.tuempresa.talleres.dto.RegistroParticipanteRequest;
import com.tuempresa.talleres.dto.ParticipanteResponse;
import com.tuempresa.talleres.service.ParticipanteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/participantes")
@CrossOrigin(origins = "*")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public ResponseEntity<List<ParticipanteResponse>> getAllParticipantes() {
        List<Participante> participantes = participanteService.findAll();
        List<ParticipanteResponse> response = participantes.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteResponse> getParticipanteById(@PathVariable Long id) {
        return participanteService.findById(id)
                .map(this::convertToResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ParticipanteResponse> createParticipante(@RequestBody RegistroParticipanteRequest request) {
        try {
            Participante participante = new Participante();
            participante.setNombre(request.getNombre());
            participante.setApellido(request.getApellido());
            participante.setEmail(request.getEmail());
            participante.setTelefono(request.getTelefono());
            participante.setInstitucion(request.getInstitucion());
            
            Participante savedParticipante = participanteService.save(participante);
            return ResponseEntity.ok(convertToResponse(savedParticipante));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteResponse> updateParticipante(@PathVariable Long id, @RequestBody RegistroParticipanteRequest request) {
        if (!participanteService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        Participante participante = new Participante();
        participante.setId(id);
        participante.setNombre(request.getNombre());
        participante.setApellido(request.getApellido());
        participante.setEmail(request.getEmail());
        participante.setTelefono(request.getTelefono());
        participante.setInstitucion(request.getInstitucion());
        
        Participante updatedParticipante = participanteService.save(participante);
        return ResponseEntity.ok(convertToResponse(updatedParticipante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipante(@PathVariable Long id) {
        if (!participanteService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        participanteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private ParticipanteResponse convertToResponse(Participante participante) {
        ParticipanteResponse response = new ParticipanteResponse();
        response.setId(participante.getId());
        response.setNombre(participante.getNombre());
        response.setApellido(participante.getApellido());
        response.setEmail(participante.getEmail());
        response.setTelefono(participante.getTelefono());
        response.setInstitucion(participante.getInstitucion());
        return response;
    }
}