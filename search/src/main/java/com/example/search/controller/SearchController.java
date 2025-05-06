package com.example.search.controller;

import com.example.search.pojo.Student;
import com.example.search.service.SearchService;
import com.example.search.service.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
public class SearchController {

    @Autowired
    private final SearchServiceImpl searchServiceImpl;

    public SearchController(SearchServiceImpl searchServiceImpl) {
        this.searchServiceImpl = searchServiceImpl;
    }

    @GetMapping("/weather/search")
    public ResponseEntity<?> getDetails() {
        return new ResponseEntity<>("this is search service", HttpStatus.OK);
    }

    @GetMapping("/weather/search/getStu")
    public CompletableFuture<ResponseEntity<?>> getStu(){
        CompletableFuture<Map<String,String>> futureStudents = searchServiceImpl.searchForStudentAsync();
        return futureStudents.thenApply(stus -> new ResponseEntity<>("weather search for stu" + stus, HttpStatus.OK));
    }

    @GetMapping("/weather/search/details")
    public CompletableFuture<ResponseEntity<?>> getDetailsPort(){
        CompletableFuture<String> detailsPort = searchServiceImpl.searchForDetailsAsync();
        return detailsPort.thenApply(port -> new ResponseEntity<>("weather search for details port" + port, HttpStatus.OK));
    }

}
