package com.proyecto.fabrica.ps.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "screws")
public class Screw {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long screwId;

	@NotNull
	@Size(min = 2, max = 100, message = "El nombre debe tener al menos 2 letras")
	private String name;
	
	@OneToMany(mappedBy = "screw", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Article> articleScrew;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	public Screw() {}
	
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public List<Article> getArticleScrew() {
		return articleScrew;
	}

	public void setArticleScrew(List<Article> articleScrew) {
		this.articleScrew = articleScrew;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date(); 
	}

	@PreUpdate 
	protected void onUpdate() {
		this.updatedAt = new Date(); 
	}
}
