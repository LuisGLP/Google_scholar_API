package com.challenge3.controller;

import com.challenge3.model.ScholarResponse;
import com.challenge3.service.SerpApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scholar")
public class SerpApiController {
    private final SerpApiService serpApiService;

    public SerpApiController(SerpApiService serpApiService) {
        this.serpApiService = serpApiService;
    }

    @GetMapping("/{authorId}")
    public ScholarResponse getScholar(@PathVariable String authorId) {
        return serpApiService.getScholarProfile(authorId);
    }
}