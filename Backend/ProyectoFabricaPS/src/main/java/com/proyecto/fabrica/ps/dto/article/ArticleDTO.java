package com.proyecto.fabrica.ps.dto.article;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleDTO {
	
	private Long articleId;
	private String name;
	private String code;
	private boolean toluene;
	private boolean spring;
	
	
	private BagDTO bag;
	
	private HoseDTO hose;
	
	private ScrewDTO screw;
	
	private ComponentPartDTO componentHasPart;

	public ArticleDTO() {}

	public ArticleDTO(Long articleId, String name, String code, boolean toluene, boolean spring, BagDTO bag,
			HoseDTO hose, ScrewDTO screw, ComponentPartDTO componentHasPart) {
		super();
		this.articleId = articleId;
		this.name = name;
		this.code = code;
		this.toluene = toluene;
		this.spring = spring;
		this.bag = bag;
		this.hose = hose;
		this.screw = screw;
		this.componentHasPart = componentHasPart;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isToluene() {
		return toluene;
	}

	public void setToluene(boolean toluene) {
		this.toluene = toluene;
	}

	public boolean isSpring() {
		return spring;
	}

	public void setSpring(boolean spring) {
		this.spring = spring;
	}

	public BagDTO getBag() {
		return bag;
	}

	public void setBag(BagDTO bag) {
		this.bag = bag;
	}

	public HoseDTO getHose() {
		return hose;
	}

	public void setHose(HoseDTO hose) {
		this.hose = hose;
	}

	public ScrewDTO getScrew() {
		return screw;
	}

	public void setScrew(ScrewDTO screw) {
		this.screw = screw;
	}

	public ComponentPartDTO getComponentHasPart() {
		return componentHasPart;
	}

	public void setComponentHasPart(ComponentPartDTO componentHasPart) {
		this.componentHasPart = componentHasPart;
	}
}
