package com.tuempresa.talleres.controller;

import com.tuempresa.talleres.model.Inscripcion;
import com.tuempresa.talleres.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {
    @Autowired
    private InscripcionService service;

    @GetMapping
    public List<Inscripcion> listar() { return service.listar(); }

    @PostMapping
    public Inscripcion guardar(@RequestBody Inscripcion inscripcion) { return service.guardar(inscripcion); }
}