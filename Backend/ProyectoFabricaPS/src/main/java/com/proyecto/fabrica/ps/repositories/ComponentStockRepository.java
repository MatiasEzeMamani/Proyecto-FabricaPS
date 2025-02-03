package com.proyecto.fabrica.ps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.fabrica.ps.models.ComponentStock;

@Repository
public interface ComponentStockRepository extends JpaRepository <ComponentStock, Long>{
	
}

