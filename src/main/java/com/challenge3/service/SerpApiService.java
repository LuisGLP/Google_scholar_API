package com.challenge3.service;

import com.challenge3.model.ScholarResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SerpApiService {

    private final RestTemplate restTemplate =  new RestTemplate();

    @Value("${serpapi.api.key}")
    private String apiKey;
    private String url = "https://serpapi.com/search.json?engine=google_scholar_author&author_id=";
    public String getScholarProfileJson(String authorId) {
        url = url + authorId + "&api_key=" + apiKey;;

        // Devuelve el JSON completo como String
        return restTemplate.getForObject(url, String.class);
    }

    public ScholarResponse getScholarProfile(String authorId) {
        url = url + authorId + "&api_key=" + apiKey;;

        // Devuelve el JSON completo como String
        return restTemplate.getForObject(url, ScholarResponse.class);
    }
}
