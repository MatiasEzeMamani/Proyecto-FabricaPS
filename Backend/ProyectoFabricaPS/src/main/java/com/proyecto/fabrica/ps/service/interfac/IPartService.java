package com.proyecto.fabrica.ps.service.interfac;

import com.proyecto.fabrica.ps.dto.PartDTO;
import com.proyecto.fabrica.ps.dto.Response;
import com.proyecto.fabrica.ps.models.Worker;

public interface IPartService {
	
	Response addPart(PartDTO partDTO);
	Response updatedPart(Long id, PartDTO partDTO);
	Response deletePart(Long id, Worker currentUser);
	Response getPartById(Long id);
	Response getAllParts();

}
