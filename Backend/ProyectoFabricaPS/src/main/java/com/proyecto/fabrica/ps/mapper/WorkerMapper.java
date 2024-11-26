package com.proyecto.fabrica.ps.mapper;

import org.mapstruct.Mapper;

import com.proyecto.fabrica.ps.dto.WorkerDTO;
import com.proyecto.fabrica.ps.models.Worker;

@Mapper(componentModel = "spring")
public interface WorkerMapper {
	
	WorkerDTO workerToWorkerDTO(Worker worker);
}
