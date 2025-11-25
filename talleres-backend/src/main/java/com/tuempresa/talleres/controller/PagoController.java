package com.tuempresa.talleres.controller;

import com.tuempresa.talleres.model.Pago;
import com.tuempresa.talleres.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {
    @Autowired
    private PagoService service;

    @GetMapping
    public List<Pago> listar() { return service.listar(); }
    @PostMapping
    public Pago guardar(@RequestBody Pago pago) { return service.guardar(pago); }
}