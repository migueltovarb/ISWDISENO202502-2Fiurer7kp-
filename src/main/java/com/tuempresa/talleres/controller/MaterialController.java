package com.tuempresa.talleres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tuempresa.talleres.model.Material;
import com.tuempresa.talleres.service.MaterialService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materiales")
@CrossOrigin(origins = "*")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public ResponseEntity<List<Material>> getAllMateriales() {
        List<Material> materiales = materialService.findAll();
        return ResponseEntity.ok(materiales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Long id) {
        Optional<Material> material = materialService.findById(id);
        return material.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<Material>> getMaterialesByEvento(@PathVariable Long eventoId) {
        List<Material> materiales = materialService.findByEventoId(eventoId);
        return ResponseEntity.ok(materiales);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Material>> getMaterialesByTipo(@PathVariable String tipo) {
        List<Material> materiales = materialService.findByTipo(tipo);
        return ResponseEntity.ok(materiales);
    }

    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        try {
            Material savedMaterial = materialService.save(material);
            return ResponseEntity.ok(savedMaterial);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Long id, @RequestBody Material material) {
        if (!materialService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        material.setId(id);
        Material updatedMaterial = materialService.save(material);
        return ResponseEntity.ok(updatedMaterial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        if (!materialService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        materialService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}