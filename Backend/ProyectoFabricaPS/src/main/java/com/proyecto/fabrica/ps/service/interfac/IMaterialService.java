package com.proyecto.fabrica.ps.service.interfac;

import com.proyecto.fabrica.ps.dto.Response;
import com.proyecto.fabrica.ps.dto.material.MaterialDTO;
import com.proyecto.fabrica.ps.models.Worker;

public interface IMaterialService {
	
	Response addMaterial(MaterialDTO materialDTO);
	Response updatedMaterial(Long id, MaterialDTO materialDTO);
	Response deleteMaterial(Long id, Worker currentUser);
	Response getMaterialById(Long id);
	Response getAllMaterials();
}
