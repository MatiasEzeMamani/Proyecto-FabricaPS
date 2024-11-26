package com.proyecto.fabrica.ps.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.proyecto.fabrica.ps.dto.WorkerDTO;
import com.proyecto.fabrica.ps.models.Worker;

@Mapper(componentModel = "spring")
public interface WorkerMapper {
	
	WorkerDTO workerToWorkerDTO(Worker worker);
	
	List<WorkerDTO> workersToWorkerDTOs(List<Worker> workers);
}
