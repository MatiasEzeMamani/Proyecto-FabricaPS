package com.proyecto.fabrica.ps.dto.article;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScrewDTO {

	private Long screwId;
	
	private String name;
	
	public ScrewDTO() {}

	public Long getScrewId() {
		return screwId;
	}

	public void setScrewId(Long screwId) {
		this.screwId = screwId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
