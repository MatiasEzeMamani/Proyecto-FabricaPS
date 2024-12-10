package com.proyecto.fabrica.ps.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.fabrica.ps.dto.Response;
import com.proyecto.fabrica.ps.dto.article.ArticleDTO;
import com.proyecto.fabrica.ps.service.interfac.IArticleService;

@Service
public class ArticleService implements IArticleService {

	private List<ArticleDTO> articles = new ArrayList<>();
	private Long currentId = 1L;

	@Override
	public Response saveArticle(ArticleDTO articleDTO) {
		Response response = new Response();

		// Validar que el artículo no exista ya
		if (articles.stream().anyMatch(a -> a.getArticleId().equals(articleDTO.getArticleId()))) {
			response.setStatusCode(409); // Conflicto
			response.setMessage("El artículo ya existe");
			return response;
		}

		articleDTO.setArticleId(currentId++); // Asignar un nuevo ID
		articles.add(articleDTO); // Guardar el artículo en la lista
		response.setStatusCode(201);
		response.setMessage("Artículo creado con éxito");
		response.setArticle(articleDTO); // Devolver el artículo creado
		return response;
	}

	@Override
	public Response getArticleById(Long articleId) {
		Response response = new Response();
		Optional<ArticleDTO> article = articles.stream().filter(a -> a.getArticleId().equals(articleId)).findFirst();

		if (article.isPresent()) {
			response.setStatusCode(200);
			response.setMessage("Artículo encontrado");
			response.setArticle(article.get()); // Devolver el artículo encontrado
		} else {
			response.setStatusCode(404);
			response.setMessage("Artículo no encontrado");
		}

		return response;
	}

	@Override
	public Response getAllArticles() {
		Response response = new Response();
		response.setStatusCode(200);
		response.setMessage("Lista de artículos obtenida");
		response.setArticleList(articles); // Devolver la lista de artículos
		return response;
	}

	@Override
	public Response deleteArticle(Long articleId) {
		Response response = new Response();
		Optional<ArticleDTO> article = articles.stream().filter(a -> a.getArticleId().equals(articleId)).findFirst();

		if (article.isPresent()) {
			articles.remove(article.get()); // Eliminar el artículo
			response.setStatusCode(200);
			response.setMessage("Artículo eliminado con éxito");
		} else {
			response.setStatusCode(404);
			response.setMessage("Artículo no encontrado");
		}

		return response;
	}
}
