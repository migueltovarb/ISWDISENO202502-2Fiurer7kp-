package com.tuempresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tuempresa.model.Ponente;
import com.tuempresa.service.PonenteService;

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
    public ResponseEntity<Ponente> createPonente(@RequestBody Ponente ponente) {
        Ponente savedPonente = ponenteService.save(ponente);
        return ResponseEntity.ok(savedPonente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ponente> updatePonente(@PathVariable Long id, @RequestBody Ponente ponente) {
        if (!ponenteService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ponente.setId(id);
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