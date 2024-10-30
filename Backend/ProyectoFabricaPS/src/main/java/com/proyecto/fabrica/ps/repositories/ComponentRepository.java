package com.proyecto.fabrica.ps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.fabrica.ps.models.Component;

public interface ComponentRepository extends JpaRepository<Component, Long> {

}
