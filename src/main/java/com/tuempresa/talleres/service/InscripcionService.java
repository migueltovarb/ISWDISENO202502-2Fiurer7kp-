package com.tuempresa.talleres.service;

import com.tuempresa.talleres.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("null")
public class InscripcionService {
    @Autowired
    private InscriptionRepository repo;
    
    public List<?> listar() { 
        return repo.findAll(); 
    }
    
    public Object guardar(Object ins) { 
        return repo.save((com.tuempresa.talleres.model.Inscription)ins); 
    }
}
