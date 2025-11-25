package com.tuempresa.talleres.service;

import com.tuempresa.talleres.model.Material;
import com.tuempresa.talleres.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public Optional<Material> findById(Long id) {
        return materialRepository.findById(id);
    }

    public List<Material> findByEventoId(Long eventoId) {
        return materialRepository.findByEventoId(eventoId);
    }

    public List<Material> findByTipo(String tipo) {
        return materialRepository.findByTipo(tipo);
    }

    public Material save(Material material) {
        return materialRepository.save(material);
    }

    public void deleteById(Long id) {
        materialRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return materialRepository.existsById(id);
    }
}
