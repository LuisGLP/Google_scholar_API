package com.challenge3.controller;

import com.challenge3.model.Author;
import com.challenge3.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{authorId}")
    public Author fetchAndSaveAuthor(@PathVariable String authorId) throws Exception {
        return authorService.fetchAndSaveFromSerpApi(authorId);
    }
}