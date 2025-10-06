package com.challenge3.service;

import com.challenge3.model.Article;
import com.challenge3.model.Author;
import com.challenge3.repository.AuthorRepository;
import com.fasterxml.jackson.databind.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final ObjectMapper mapper;
    private final SerpApiService serpApiService;

    public AuthorService(AuthorRepository authorRepository, ObjectMapper mapper, SerpApiService serpApiService) {
        this.authorRepository = authorRepository;
        this.mapper = mapper;
        this.serpApiService = serpApiService;
    }

    // Nuevo metodo para consultar API y guardar datos
    public Author fetchAndSaveFromSerpApi(String authorId) throws Exception {
        //  Obtener JSON de SerpAPI
        String json = serpApiService.getScholarProfileJson(authorId);

        //  Parsear el JSON
        JsonNode root = mapper.readTree(json);

        //  Crear el autor
        JsonNode authorNode = root.path("author");
        Author author = new Author();
        author.setAuthorId(root.path("search_parameters").path("author_id").asText());
        author.setName(authorNode.path("name").asText());
        author.setEmail(authorNode.path("email").asText(null));
        author.setWebsite(authorNode.path("website").asText(null));

        List<String> interests = new ArrayList<>();
        for (JsonNode i : authorNode.path("interests")) {
            interests.add(i.path("title").asText());
        }
        author.setInterests(interests);

        JsonNode citations = root.path("cited_by").path("table").get(0).path("citations");
        author.setTotalCitations(citations.path("all").asInt(0));

        //  Extraer artículos
        List<Article> articles = new ArrayList<>();
        for (JsonNode artNode : root.path("articles")) {
            Article a = new Article();
            a.setTitle(artNode.path("title").asText());
            a.setAuthors(artNode.path("authors").asText());
            a.setYear(artNode.path("year").asText());
            a.setLink(artNode.path("link").asText());
            a.setCitedBy(artNode.path("cited_by").path("value").asInt(0));
            a.setAuthor(author);
            articles.add(a);
        }
        author.setArticles(articles);

        // Guardar en la base de datos
        return authorRepository.save(author);
    }
}