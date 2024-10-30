package com.proyecto.fabrica.ps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.fabrica.ps.models.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {

}
