package com.proyecto.fabrica.ps.service.interfac;

import com.proyecto.fabrica.ps.dto.Response;

public interface IComponentStockService {
	Response addStock(Long componentId, int quantity);
	Response reduceStock(Long componentId, int quantity);
	Response getStockByComponentId(Long componentId);
	Response getAllComponentsStock();
}
