package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RestController
public class ShopController {

    @GetMapping
    public String hello() {
        return "Добро пожаловать!";
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {;
        return getAllProducts();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return getAllArticles();
    }

    @GetMapping("/search")
    public String search(@RequestParam String pattern) {
        Set<Boolean> results = new HashSet<>();
        for (Product product : getAllProducts()) {
            for (Article article : getAllArticles()) {
                results.add(product.getTitle().equalsIgnoreCase(pattern));
                results.add(article.getArticleTitle().equalsIgnoreCase(pattern));
            }
        }
        return results.toString();
    }

}