package com.tuempresa.talleres.service;

import com.tuempresa.talleres.model.Ponente;
import com.tuempresa.talleres.repository.PonenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PonenteService {

    @Autowired
    private PonenteRepository ponenteRepository;

    public List<Ponente> findAll() {
        return ponenteRepository.findAll();
    }

    public Optional<Ponente> findById(Long id) {
        return ponenteRepository.findById(id);
    }

    public Ponente save(Ponente ponente) {
        return ponenteRepository.save(ponente);
    }

    public void deleteById(Long id) {
        ponenteRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return ponenteRepository.existsById(id);
    }
}