package com.tuempresa.talleres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tuempresa.talleres.model.Pago;
import com.tuempresa.talleres.service.PagoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> getAllPagos() {
        List<Pago> pagos = pagoService.findAll();
        return ResponseEntity.ok(pagos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        Optional<Pago> pago = pagoService.findById(id);
        return pago.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/inscripcion/{inscripcionId}")
    public ResponseEntity<List<Pago>> getPagosByInscripcion(@PathVariable Long inscripcionId) {
        List<Pago> pagos = pagoService.findByInscriptionId(inscripcionId);
        return ResponseEntity.ok(pagos);
    }

    @GetMapping("/participante/{participanteId}")
    public ResponseEntity<List<Pago>> getPagosByParticipante(@PathVariable Long participanteId) {
        List<Pago> pagos = pagoService.findByParticipanteId(participanteId);
        return ResponseEntity.ok(pagos);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Pago>> getPagosByEstado(@PathVariable String estado) {
        List<Pago> pagos = pagoService.findByEstado(estado);
        return ResponseEntity.ok(pagos);
    }

    @PostMapping
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago) {
        try {
            Pago savedPago = pagoService.save(pago);
            return ResponseEntity.ok(savedPago);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Pago> updateEstadoPago(
            @PathVariable Long id, 
            @RequestParam String estado) {
        return pagoService.findById(id)
                .map(pago -> {
                    pago.setEstado(estado);
                    Pago updatedPago = pagoService.save(pago);
                    return ResponseEntity.ok(updatedPago);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        if (!pagoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pagoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}