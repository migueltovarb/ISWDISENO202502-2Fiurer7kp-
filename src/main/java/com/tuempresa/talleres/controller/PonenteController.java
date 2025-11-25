package com.tuempresa.talleres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tuempresa.talleres.model.Ponente;
import com.tuempresa.talleres.dto.RegisterPonenteRequest;
import com.tuempresa.talleres.service.PonenteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ponentes")
@CrossOrigin(origins = "*")
public class PonenteController {

    @Autowired
    private PonenteService ponenteService;

    @GetMapping
    public ResponseEntity<List<Ponente>> getAllPonentes() {
        List<Ponente> ponentes = ponenteService.findAll();
        return ResponseEntity.ok(ponentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ponente> getPonenteById(@PathVariable Long id) {
        Optional<Ponente> ponente = ponenteService.findById(id);
        return ponente.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ponente> createPonente(@RequestBody RegisterPonenteRequest request) {
        try {
            Ponente ponente = new Ponente();
            ponente.setNombre(request.getNombre());
            ponente.setApellido(request.getApellido());
            ponente.setEmail(request.getEmail());
            ponente.setEspecialidad(request.getEspecialidad());
            ponente.setTelefono(request.getTelefono());
            
            Ponente savedPonente = ponenteService.save(ponente);
            return ResponseEntity.ok(savedPonente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ponente> updatePonente(@PathVariable Long id, @RequestBody RegisterPonenteRequest request) {
        if (!ponenteService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        Ponente ponente = new Ponente();
        ponente.setId(id);
        ponente.setNombre(request.getNombre());
        ponente.setApellido(request.getApellido());
        ponente.setEmail(request.getEmail());
        ponente.setEspecialidad(request.getEspecialidad());
        ponente.setTelefono(request.getTelefono());
        
        Ponente updatedPonente = ponenteService.save(ponente);
        return ResponseEntity.ok(updatedPonente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePonente(@PathVariable Long id) {
        if (!ponenteService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ponenteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}