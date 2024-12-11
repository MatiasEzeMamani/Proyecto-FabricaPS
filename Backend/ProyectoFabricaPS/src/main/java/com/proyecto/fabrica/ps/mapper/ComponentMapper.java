package com.proyecto.fabrica.ps.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.proyecto.fabrica.ps.dto.ComponentDTO;
import com.proyecto.fabrica.ps.models.Component;

@Mapper(componentModel = "spring")
public interface ComponentMapper {
	
	ComponentDTO componentToComponentDTO(Component component);
	
	List<ComponentDTO> componentsToComponentDTOs(List<Component> component);
}
