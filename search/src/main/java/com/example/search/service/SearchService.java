package com.example.search.service;

import com.example.search.pojo.Student;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface SearchService {
    public CompletableFuture<String> searchForStudentAsync();
    public CompletableFuture<String> searchForDetailsAsync();
}
