package com.proyecto.fabrica.ps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.fabrica.ps.models.MovementDetail;

@Repository
public interface MovementDetailRepository extends JpaRepository<MovementDetail, Long> {

}
