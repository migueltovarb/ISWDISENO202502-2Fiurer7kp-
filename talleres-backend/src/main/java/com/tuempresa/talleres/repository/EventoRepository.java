package com.tuempresa.talleres.repository;

import com.tuempresa.talleres.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> { }