package com.proyecto.fabrica.ps.dto;

import com.proyecto.fabrica.ps.models.Article;
import com.proyecto.fabrica.ps.models.Component;
import com.proyecto.fabrica.ps.models.Part;
import com.proyecto.fabrica.ps.models.Warehouse;

public class StockDTO {
	
	private Long stockId;

	private int quantity;

	private Warehouse warehouse;

	private Part part;

	private Component component;

	private Article article;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	
}
