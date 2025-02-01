package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> product;
    private final Map<UUID, Article> article;

    public StorageService() {
        this.product = new HashMap<>();
        this.article = new HashMap<>();
        addProductsAndArticles();
    }

    private void addProductsAndArticles() {
        product.put(UUID.randomUUID(), new SimpleProduct(UUID.randomUUID(), "Арбуз", 100));
        product.put(UUID.randomUUID(), new SimpleProduct(UUID.randomUUID(), "Груши", 100));
        product.put(UUID.randomUUID(), new DiscountedProduct(UUID.randomUUID(), "Яблоки", 80, 5));
        product.put(UUID.randomUUID(), new DiscountedProduct(UUID.randomUUID(), "Виноград", 90, 8));
        product.put(UUID.randomUUID(), new FixPriceProduct(UUID.randomUUID(), "Вишня"));
        product.put(UUID.randomUUID(), new FixPriceProduct(UUID.randomUUID(), "Черешня"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "World", "This is my world and my life"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Java code", "Development in Java code"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Alone man", "The history for alone man"));
    }

    public Collection<Product> getAllProducts() {
        return product.values();
    }

    public Collection<Article> getAllArticles() {
        return article.values();
    }

    public Set<Searchable> getSearchable() {
        Set<Searchable> searchable = new HashSet<>();
        searchable.addAll(product.values());
        searchable.addAll(article.values());
        return searchable;
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(product.get(id));
    }

}
