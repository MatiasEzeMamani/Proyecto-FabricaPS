package com.proyecto.fabrica.ps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.fabrica.ps.dto.ComponentStockDTO;
import com.proyecto.fabrica.ps.dto.Response;
import com.proyecto.fabrica.ps.exception.OurException;
import com.proyecto.fabrica.ps.mapper.ComponentStockMapper;
import com.proyecto.fabrica.ps.models.Component;
import com.proyecto.fabrica.ps.repositories.ComponentRepository;
import com.proyecto.fabrica.ps.service.interfac.IComponentStockService;

@Service
public class ComponentStockService implements IComponentStockService {

	@Autowired
	private ComponentRepository componentRepository;

	@Autowired
	private ComponentStockMapper componentStockMapper;

	@Override
	public Response addStock(Long componentId, int quantity) {

		Response response = new Response();

		try {

			Component component = componentRepository.findById(componentId)
					.orElseThrow(() -> new OurException("Componente no encontrado con ID: " + componentId));

			component.setStock(component.getStock() + quantity);
			Component updatedComponent = componentRepository.save(component);

			response.setStatusCode(200);
			response.setMessage("Stock actualizado correctamente.");
			response.setComponentStock(componentStockMapper.componentToComponentStockDTO(updatedComponent));

		} catch (OurException e) {

			response.setStatusCode(400);
			response.setMessage(e.getMessage());

		} catch (Exception e) {

			response.setStatusCode(500);
			response.setMessage("Error al actualizar el stock: " + e.getMessage());

		}

		return response;
	}

	@Override
	public Response reduceStock(Long componentId, int quantity) {

		Response response = new Response();

		try {

			Component component = componentRepository.findById(componentId)
					.orElseThrow(() -> new OurException("Componente no encontrado con ID: " + componentId));

			if (component.getStock() < quantity) {
				throw new OurException("Stock insuficiente para reducir.");
			}
			
			component.setStock(component.getStock() - quantity);
            Component updatedComponent = componentRepository.save(component);

            response.setStatusCode(200);
            response.setMessage("Stock reducido correctamente.");
            response.setComponentStock(componentStockMapper.componentToComponentStockDTO(updatedComponent));

		} catch (OurException e) {
			
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
            
        } catch (Exception e) {
        	
            response.setStatusCode(500);
            response.setMessage("Error al reducir el stock: " + e.getMessage());
            
        }

        return response;
	}

	@Override
	public Response getStockByComponentId(Long componentId) {

		 Response response = new Response();

	        try {
	            Component component = componentRepository.findById(componentId)
	                    .orElseThrow(() -> new OurException("Componente no encontrado con ID: " + componentId));

	            ComponentStockDTO componentStockDTO = componentStockMapper.componentToComponentStockDTO(component);

	            response.setStatusCode(200);
	            response.setMessage("Stock obtenido correctamente.");
	            response.setComponentStock(componentStockDTO);

	        } catch (OurException e) {
	            response.setStatusCode(400);
	            response.setMessage(e.getMessage());
	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error al obtener el stock: " + e.getMessage());
	        }

	        return response;
	}

	@Override
    public Response getAllComponentsStock() {
        Response response = new Response();

        try {
        	
            List<Component> components = componentRepository.findAll();
            List<ComponentStockDTO> componentStockDTOList = componentStockMapper.componentsToComponentStockDTOs(components);

            response.setStatusCode(200);
            response.setMessage("Lista de stocks obtenida correctamente.");
            response.setComponentStockList(componentStockDTOList);

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error al obtener los stocks: " + e.getMessage());
        }

        return response;
    }
}
