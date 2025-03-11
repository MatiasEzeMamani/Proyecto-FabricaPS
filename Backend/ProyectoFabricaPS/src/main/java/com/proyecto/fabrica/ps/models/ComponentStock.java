package com.proyecto.fabrica.ps.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
@Table(name = "component_stock")
public class ComponentStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long componentStockId;
	
	@Min(0)
	@Column(nullable = false)
	private int availableStock;
	
	@Min(0)
	@Column(nullable = false)
	private int canBeProduced ;
	
	@OneToOne
    @JoinColumn(name = "componentId", referencedColumnName = "componentId")
    private Component component;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	public ComponentStock() {}
	
	public Long getComponentStockId() {
		return componentStockId;
	}

	public void setComponentStockId(Long componentStockId) {
		this.componentStockId = componentStockId;
	}
	
	public int getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}

	public int getCanBeProduced() {
		return canBeProduced;
	}

	public void setCanBeProduced(int canBeProduced) {
		this.canBeProduced = canBeProduced;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
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
		Date currentDate = new Date();
		this.createdAt = currentDate;
	    this.updatedAt = currentDate;
	}

	@PreUpdate 
	protected void onUpdate() {
		this.updatedAt = new Date(); 
	}
}
