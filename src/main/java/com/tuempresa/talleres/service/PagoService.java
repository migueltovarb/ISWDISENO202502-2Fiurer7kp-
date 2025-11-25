package com.tuempresa.talleres.service;

import com.tuempresa.talleres.model.Pago;
import com.tuempresa.talleres.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {
    @Autowired
    private PagoRepository repo;
    public List<Pago> listar() { return repo.findAll(); }
    public Pago guardar(Pago pago) { return repo.save(pago); }
}