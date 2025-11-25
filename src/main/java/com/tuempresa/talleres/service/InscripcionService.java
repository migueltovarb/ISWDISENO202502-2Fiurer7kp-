package com.tuempresa.talleres.service;

import com.tuempresa.talleres.model.Inscripcion;
import com.tuempresa.talleres.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository repo;
    public List<Inscripcion> listar() { return repo.findAll(); }
    public Inscripcion guardar(Inscripcion ins) { return repo.save(ins); }
}