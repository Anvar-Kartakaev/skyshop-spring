package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.SearchResult;
import org.skypro.skyshop.model.search.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestController
public class ShopController {
    private final SearchService searchService;
    private final StorageService storageService;
    private final BasketService basketService;

    public ShopController(SearchService searchService, StorageService storageService, BasketService basketService) {
        this.searchService = searchService;
        this.storageService = storageService;
        this.basketService = basketService;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать!";
    }

    @GetMapping("/products")
    public Map<UUID, Product> getAllProducts() {
        return storageService.getAllProducts();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.getAllArticles();
    }

    @GetMapping("/search")
    public Set<SearchResult> search(@RequestParam String pattern) {
        return searchService.search(pattern);
    }

    @GetMapping("/basket/{id}")
    public String addProductToBasket(@PathVariable("id") UUID id) {
        this.basketService.addProductToBasket(id);
        return "*Продукт успешно добавлен*";
    }

    @GetMapping("/basket")
    public UserBasket getUserBasket() {
        return basketService.getUserBasket();
    }
}