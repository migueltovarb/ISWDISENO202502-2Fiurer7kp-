package com.tuempresa.talleres.service;

import com.tuempresa.talleres.model.Evento;
import com.tuempresa.talleres.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> listarEventos() { return eventoRepository.findAll(); }
    public Evento crearEvento(Evento evento) { return eventoRepository.save(evento); }
}