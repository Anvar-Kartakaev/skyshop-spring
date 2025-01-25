package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

@RestController
public class ShopController {
    private final SearchService searchService;
    private final StorageService storageService;

    public ShopController(SearchService searchService, StorageService storageService) {
        this.searchService = searchService;
        this.storageService = storageService;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать!";
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.getAllProducts();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.getAllArticles();
    }

    @GetMapping("/search")
    public Set<Searchable> search(@RequestParam String pattern) {
        return searchService.search(pattern);
    }

}