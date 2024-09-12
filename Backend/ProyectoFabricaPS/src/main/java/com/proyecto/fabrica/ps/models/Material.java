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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "materials")
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long material_id;

	@NotNull
	private int code;

	@NotNull
	@Size(min = 0, max = 300)
	private int stock;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "abbreviation_id")
	private Abbreviation abbreviation;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "color_id")
	private Color color;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "type_material_id")
	private TypeMaterial type_material;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "name_material_id")
	private NameMaterial name_material;

	@OneToMany(mappedBy = "materialBrand", cascade = CascadeType.ALL)
	private List<MaterialFormData> materialFormData;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	public Long getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(Long material_id) {
		this.material_id = material_id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Abbreviation getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(Abbreviation abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public TypeMaterial getType_material() {
		return type_material;
	}

	public void setType_material(TypeMaterial type_material) {
		this.type_material = type_material;
	}

	public NameMaterial getName_material() {
		return name_material;
	}

	public void setName_material(NameMaterial name_material) {
		this.name_material = name_material;
	}

	public List<MaterialFormData> getMaterialFormData() {
		return materialFormData;
	}

	public void setMaterialFormData(List<MaterialFormData> materialFormData) {
		this.materialFormData = materialFormData;
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
