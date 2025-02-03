package com.proyecto.fabrica.ps.service.interfac;

import com.proyecto.fabrica.ps.dto.Response;
import com.proyecto.fabrica.ps.models.Worker;

public interface IComponentPartService {
	
	Response addComponentPart(Long componentId, Long partId, int quantity);

	Response getAllComponentsParts();

	Response getComponentPartByComponent(Long componentId);

	Response getComponentPartByPart(Long partId);

	Response deleteComponentPart(Long componentId, Worker currentUser);
    
}