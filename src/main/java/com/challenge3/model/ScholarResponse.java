package com.challenge3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class ScholarResponse {
    private String authorId;
    private String name;
    private String website;

    @JsonProperty("articles")
    private List<Article> articles;

    // Desempaqueta el JSON "author": { ... }
    @JsonProperty("author")
    private void unpackAuthor(Map<String, Object> author) {
        this.authorId = (String) author.get("author_id");
        this.name = (String) author.get("name");
        this.website = (String) author.get("website");
    }

}
