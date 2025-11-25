package com.tuempresa.talleres.controller;

import com.tuempresa.talleres.model.Evento;
import com.tuempresa.talleres.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> listarEventos() { return eventoService.listarEventos(); }

    @PostMapping
    public Evento crearEvento(@RequestBody Evento evento) { return eventoService.crearEvento(evento); }
}