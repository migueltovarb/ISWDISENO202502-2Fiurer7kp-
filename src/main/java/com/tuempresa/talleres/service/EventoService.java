package com.tuempresa.talleres.service;

import com.tuempresa.talleres.model.Evento;
import com.tuempresa.talleres.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> listarEventos() { 
        return eventoRepository.findAll(); 
    }
    
    public Evento crearEvento(Evento evento) { 
        return eventoRepository.save(evento); 
    }
    
    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }
    
    public Optional<Evento> findById(Long id) {
        return eventoRepository.findById(id);
    }
    
    public List<Evento> findByEstado(String estado) {
        return eventoRepository.findByEstado(estado);
    }
    
    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }
    
    public void deleteById(Long id) {
        eventoRepository.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return eventoRepository.existsById(id);
    }
}