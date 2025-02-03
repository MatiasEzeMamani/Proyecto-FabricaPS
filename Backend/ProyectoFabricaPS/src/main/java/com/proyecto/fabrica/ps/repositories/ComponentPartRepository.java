package com.proyecto.fabrica.ps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.fabrica.ps.models.ComponentPart;

public interface ComponentPartRepository extends JpaRepository<ComponentPart, Long> {

	List<ComponentPart> findByComponent_ComponentId(Long componentId);

	List<ComponentPart> findByPart_PartId(Long partId);

}
