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
        addBase();
    }

    private void addBase() {
        Product product1 = new SimpleProduct(UUID.randomUUID(), "Арбуз", 100);
        Product product2 = new DiscountedProduct(UUID.randomUUID(), "Яблоки", 80, 5);
        Product product3 = new FixPriceProduct(UUID.randomUUID(), "Вишня");
        Article article1 = new Article(UUID.randomUUID(), "World", "This is my world and my life");
        Article article2 = new Article(UUID.randomUUID(), "Java code", "Development in Java code");
        Article article3 = new Article(UUID.randomUUID(), "Alone man", "The history for alone man");
    }

    public Collection<Product> getAllProducts() {
        return product.values();
    }

    public Collection<Article> getAllArticles() {
        return article.values();
    }

    public Set<Searchable> getSearchable() {
        Set<Searchable> searchable = new HashSet<>();
        for (Product product : product.values()) {
            for (Article article : article.values()) {
                searchable.add(product);
                searchable.add(article);
            }
        }
        return searchable;
    }

}
