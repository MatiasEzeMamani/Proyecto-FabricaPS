package com.proyecto.fabrica.ps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.fabrica.ps.dto.Response;
import com.proyecto.fabrica.ps.dto.article.ArticleDTO;
import com.proyecto.fabrica.ps.service.interfac.IArticleService;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
	@Autowired
    private IArticleService articleService; // Inyectar el servicio de artículos

    @PostMapping
    public ResponseEntity<Response> createArticle(@RequestBody ArticleDTO articleDTO) {
        Response response = articleService.saveArticle(articleDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getArticleById(@PathVariable Long id) {
        Response response = articleService.getArticleById(id);
        return new ResponseEntity<>(response, response.getStatusCode() == 200 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<Response> getAllArticles() {
        Response response = articleService.getAllArticles();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteArticle(@PathVariable Long id) {
        Response response = articleService.deleteArticle(id);
        return new ResponseEntity<>(response, response.getStatusCode() == 200 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        // Aquí, podrías necesitar implementar un método en tu servicio para actualizar el artículo.
        // Para este ejemplo, asumiré que ya tienes un método para actualizar un artículo.
        
        articleDTO.setArticleId(id); // Asegúrate de establecer el ID del artículo en el DTO
        Response response = articleService.saveArticle(articleDTO); // Usar el método de guardar para actualizar
        return new ResponseEntity<>(response, response.getStatusCode() == 200 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
