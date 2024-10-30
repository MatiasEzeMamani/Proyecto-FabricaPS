package com.proyecto.fabrica.ps.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "components_has_parts")
public class ComponentPart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long componentHasPartId;
	
	@ManyToOne
	@JoinColumn(name = "component_id")
	private Component component;
	
	@ManyToOne
	@JoinColumn(name = "part_id")
	private Part part;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	public ComponentPart() {}
	
	public Long getComponentHasPartId() {
		return componentHasPartId;
	}

	public void setComponentHasPartId(Long componentHasPartId) {
		this.componentHasPartId = componentHasPartId;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
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

	@PrePersist 
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate 
	protected void onUpdate() {
		this.updatedAt = new Date(); 
	}
}
