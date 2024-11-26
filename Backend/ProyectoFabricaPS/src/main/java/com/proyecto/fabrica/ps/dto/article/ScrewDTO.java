package com.proyecto.fabrica.ps.dto.article;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScrewDTO {

	private Long screwId;
	private String name;
	
	public ScrewDTO() {}
}
