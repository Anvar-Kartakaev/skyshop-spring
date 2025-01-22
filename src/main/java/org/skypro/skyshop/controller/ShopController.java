package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ShopController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private StorageService storageService;

    @Bean
    public SearchService getSearchService() {
        return searchService;
    }

    @Bean
    public StorageService getStorageService() {
        return storageService;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать!";
    }

    @GetMapping("/products")
    public void allProducts() {
        System.out.println(storageService.getAllProducts());
    }

    @GetMapping("/articles")
    public void allArticles() {
        System.out.println(storageService.getAllArticles());
    }

    @GetMapping("/search")
    public String search(@RequestParam("pattern") String pattern) {
        Set<Searchable> results = new HashSet<>();
        results.addAll(storageService.getAllProducts());
        results.addAll(storageService.getAllArticles());
        return results.toString();
    }

}