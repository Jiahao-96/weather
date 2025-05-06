package com.example.search.service;

import com.example.search.config.EndpointConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class SearchServiceImpl implements SearchService{
    private final RestTemplate restTemplate;

    public SearchServiceImpl(RestTemplate getRestTemplate){this.restTemplate = getRestTemplate;}

    public CompletableFuture<Map<String, String>> searchForStudentAsync(){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            String jsonResponse = restTemplate.getForObject(
                    EndpointConfig.queryStudent,
                    String.class
            );
            return jsonResponse;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            String jsonResponse = restTemplate.getForObject(
                    EndpointConfig.queryDetails, // 替换为您的实际端点
                    String.class
            );
            return jsonResponse;
        });
        return future1.thenCombine(future2, (result1, result2) -> {
            Map<String, String> combinedResult = new HashMap<>();
            combinedResult.put("studentData", result1);
            combinedResult.put("detailData", result2);

            return combinedResult;
        }).exceptionally(ex -> {
            System.err.println("error: " + ex.getMessage());
            Map<String, String> errorResult = new HashMap<>();
            errorResult.put("error", ex.getMessage());
            return errorResult;
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
