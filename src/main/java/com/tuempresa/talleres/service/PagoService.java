package com.tuempresa.talleres.service;

import com.tuempresa.talleres.model.Pago;
import com.tuempresa.talleres.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class PagoService {
    @Autowired
    private PagoRepository repo;
    
    public List<Pago> listar() { 
        return repo.findAll(); 
    }
    
    public Pago guardar(Pago pago) { 
        return repo.save(pago); 
    }
    
    public List<Pago> findAll() {
        return repo.findAll();
    }
    
    public Optional<Pago> findById(Long id) {
        return repo.findById(id);
    }
    
    public List<Pago> findByInscriptionId(Long inscriptionId) {
        return repo.findByInscripcionId(inscriptionId);
    }
    
    public List<Pago> findByParticipanteId(Long participanteId) {
        return repo.findByInscripcionParticipanteId(participanteId);
    }
    
    public List<Pago> findByEstado(String estado) {
        return repo.findByEstado(estado);
    }
    
    public Pago save(Pago pago) {
        return repo.save(pago);
    }
    
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }
}