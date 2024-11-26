package com.proyecto.fabrica.ps.dto.article;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComponentPartDTO {

	private Long componentHasPartId;
	private String componentName;
	
	
	public ComponentPartDTO() {}


	public ComponentPartDTO(Long componentHasPartId, String componentName) {
		this.componentHasPartId = componentHasPartId;
		this.componentName = componentName;
	}


	public Long getComponentHasPartId() {
		return componentHasPartId;
	}


	public void setComponentHasPartId(Long componentHasPartId) {
		this.componentHasPartId = componentHasPartId;
	}


	public String getComponentName() {
		return componentName;
	}


	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
}
