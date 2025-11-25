package com.tuempresa.talleres.repository;

import com.tuempresa.talleres.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> { }