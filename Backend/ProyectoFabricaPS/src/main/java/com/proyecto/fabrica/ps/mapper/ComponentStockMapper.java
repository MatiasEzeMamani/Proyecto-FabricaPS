package com.proyecto.fabrica.ps.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.proyecto.fabrica.ps.dto.ComponentStockDTO;
import com.proyecto.fabrica.ps.models.Component;

@Mapper(componentModel = "spring")
public interface ComponentStockMapper {
	
	ComponentStockDTO componentToComponentStockDTO(Component component);

	List<ComponentStockDTO> componentsToComponentStockDTOs(List<Component> components);
}
