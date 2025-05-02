package com.example.search.service;

import com.example.search.config.EndpointConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;

@Service
public class SearchServiceImpl implements SearchService{
    private final RestTemplate restTemplate;

    public SearchServiceImpl(RestTemplate getRestTemplate){this.restTemplate = getRestTemplate;}

    public CompletableFuture<String> searchForStudentAsync(){
        return CompletableFuture.supplyAsync(() -> {
            String jsonResponse = restTemplate.getForObject(
                    EndpointConfig.queryStudent,
                    String.class
            );
            return jsonResponse;
        });
    }

    public CompletableFuture<String> searchForDetailsAsync() {
        return CompletableFuture.supplyAsync(() -> {
            String jsonResponse = restTemplate.getForObject(
                    EndpointConfig.queryDetails,
                    String.class
            );
            return jsonResponse;
        });
    }
}
