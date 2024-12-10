package com.proyecto.fabrica.ps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.proyecto.fabrica.ps.dto.Response;
import com.proyecto.fabrica.ps.dto.material.MaterialDTO;
import com.proyecto.fabrica.ps.exception.OurException;
import com.proyecto.fabrica.ps.mapper.MaterialMapper;
import com.proyecto.fabrica.ps.models.Abbreviation;
import com.proyecto.fabrica.ps.models.Brand;
import com.proyecto.fabrica.ps.models.Color;
import com.proyecto.fabrica.ps.models.Material;
import com.proyecto.fabrica.ps.models.NameMaterial;
import com.proyecto.fabrica.ps.models.Role;
import com.proyecto.fabrica.ps.models.TypeMaterial;
import com.proyecto.fabrica.ps.models.Worker;
import com.proyecto.fabrica.ps.repositories.AbbreviationRepository;
import com.proyecto.fabrica.ps.repositories.BrandRepository;
import com.proyecto.fabrica.ps.repositories.ColorRepository;
import com.proyecto.fabrica.ps.repositories.MaterialRepository;
import com.proyecto.fabrica.ps.repositories.NameMaterialRepository;
import com.proyecto.fabrica.ps.repositories.TypeMaterialRepository;
import com.proyecto.fabrica.ps.service.interfac.IMaterialService;

@Service
public class MaterialService implements IMaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private MaterialMapper materialMapper;

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private AbbreviationRepository abbreviationRepository;

	@Autowired
	private ColorRepository colorRepository;

	@Autowired
	private TypeMaterialRepository typeMaterialRepository;

	@Autowired
	private NameMaterialRepository nameMaterialRepository;

	@Override
	public Response addMaterial(MaterialDTO materialDTO) {

		Response response = new Response();

		try {
			if (materialRepository.existsByCode(materialDTO.getCode())) {
				throw new OurException("El material con el codigo " + materialDTO.getCode() + " ya esta registrada.");
			}

			Material material = new Material();
			material.setCode(materialDTO.getCode());
			material.setStock(materialDTO.getStock());

			// Cargar entidades relacionadas por ID
			Brand brand = brandRepository.findById(materialDTO.getBrand().getBrandId()).orElseThrow(
					() -> new OurException("Marca no encontrada con ID: " + materialDTO.getBrand().getBrandId()));
			material.setBrand(brand);

			Abbreviation abbreviation = abbreviationRepository.findById(materialDTO.getAbbreviation().getAbbreviationId())
					.orElseThrow(() -> new OurException(
							"Abreviación no encontrada con ID: " + materialDTO.getAbbreviation().getAbbreviationId()));
			material.setAbbreviation(abbreviation);

			Color color = colorRepository.findById(materialDTO.getColor().getColorId()).orElseThrow(
					() -> new OurException("Color no encontrado con ID: " + materialDTO.getColor().getColorId()));
			material.setColor(color);

			TypeMaterial typeMaterial = typeMaterialRepository.findById(materialDTO.getTypeMaterial().getTypeMaterialId())
					.orElseThrow(() -> new OurException(
							"Tipo de material no encontrado con ID: " + materialDTO.getTypeMaterial().getTypeMaterialId()));
			material.setTypeMaterial(typeMaterial);

			NameMaterial nameMaterial = nameMaterialRepository.findById(materialDTO.getNameMaterial().getNameMaterialId())
					.orElseThrow(() -> new OurException(
							"Nombre de material no encontrado con ID: " + materialDTO.getNameMaterial().getNameMaterialId()));
			material.setNameMaterial(nameMaterial);

			Material saveMaterial = materialRepository.save(material);

			response.setStatusCode(200);
			response.setMessage("Material añadido exitosamente");
			response.setMaterial(materialMapper.materialToMaterialDTO(saveMaterial));

		} catch (OurException e) {

			response.setStatusCode(400);
			response.setMessage(e.getMessage());

		} catch (Exception e) {

			response.setStatusCode(500);
			response.setMessage("Error al añadir el material: " + e.getMessage());
		}

		return response;
	}

	@Override
	public Response updatedMaterial(Long id, MaterialDTO materialDTO) {

		Response response = new Response();

		try {

			Material material = materialRepository.findById(id)
					.orElseThrow(() -> new OurException("Material no encontrado con ID: " + id));

			material.setCode(materialDTO.getCode());

			Brand brand = brandRepository.findById(materialDTO.getBrand().getBrandId()).orElseThrow(
					() -> new OurException("Marca no encontrada con ID: " + materialDTO.getBrand().getBrandId()));
			material.setBrand(brand);

			Abbreviation abbreviation = abbreviationRepository
					.findById(materialDTO.getAbbreviation().getAbbreviationId()).orElseThrow(() -> new OurException(
							"Abreviación no encontrada con ID: " + materialDTO.getAbbreviation().getAbbreviationId()));
			material.setAbbreviation(abbreviation);

			Color color = colorRepository.findById(materialDTO.getColor().getColorId()).orElseThrow(
					() -> new OurException("Color no encontrado con ID: " + materialDTO.getColor().getColorId()));
			material.setColor(color);

			TypeMaterial typeMaterial = typeMaterialRepository
					.findById(materialDTO.getTypeMaterial().getTypeMaterialId())
					.orElseThrow(() -> new OurException("Tipo de material no encontrado con ID: "
							+ materialDTO.getTypeMaterial().getTypeMaterialId()));
			material.setTypeMaterial(typeMaterial);

			NameMaterial nameMaterial = nameMaterialRepository
					.findById(materialDTO.getNameMaterial().getNameMaterialId())
					.orElseThrow(() -> new OurException("Nombre de material no encontrado con ID: "
							+ materialDTO.getNameMaterial().getNameMaterialId()));
			material.setNameMaterial(nameMaterial);

			Material updatedMaterial = materialRepository.save(material);

			response.setStatusCode(200);
			response.setMessage("Material actualizado exitosamente");
			response.setMaterial(materialMapper.materialToMaterialDTO(updatedMaterial));

		} catch (OurException e) {

			response.setStatusCode(400);
			response.setMessage(e.getMessage());

		} catch (Exception e) {

			response.setStatusCode(500);
			response.setMessage("Error al actualizar el material: " + e.getMessage());

		}

		return response;
	}

	@Override
	public Response deleteMaterial(Long id, @AuthenticationPrincipal Worker currentUser) {
		Response response = new Response();

		try {

			if (!currentUser.getRole().equals(Role.ADMINISTRATOR)) {
				throw new OurException("No tienes permisos para eliminar trabajadores");
			}

			if (!materialRepository.existsById(id)) {
				throw new OurException("Material no encontrado con el ID: " + id);
			}

			materialRepository.deleteById(id);
			response.setStatusCode(200);
			response.setMessage("Material eliminado exitosamente.");

		} catch (OurException e) {

			response.setStatusCode(404);
			response.setMessage(e.getMessage());

		} catch (Exception e) {

			response.setStatusCode(500);
			response.setMessage("Error al eliminar el material: " + e.getMessage());

		}

		return response;
	}

	@Override
	public Response getMaterialById(Long id) {

		Response response = new Response();

		try {

			Material material = materialRepository.findById(id)
					.orElseThrow(() -> new OurException("Pieza no encontrada con ID: " + id));

			MaterialDTO materialDTO = materialMapper.materialToMaterialDTO(material);
			response.setStatusCode(200);
			response.setMaterial(materialDTO);

		} catch (OurException e) {

			response.setStatusCode(400);
			response.setMessage(e.getMessage());

		} catch (Exception e) {

			response.setStatusCode(500);
			response.setMessage("Error al buscar el material: " + e.getMessage());
		}

		return response;
	}

	@Override
	public Response getAllMaterials() {

		Response response = new Response();

		try {

			List<Material> materials = materialRepository.findAll();

			response.setStatusCode(200);
			response.setMessage("Lista de materiales obtenida exitosa");
			response.setMaterialList(materialMapper.materialsToMaterialDTOs(materials));

		} catch (Exception e) {

			response.setStatusCode(500);
			response.setMessage("Error al obtener los materiales: " + e.getMessage());

		}

		return response;
	}

}
