package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private String title;
    private final UUID id;

    public Product(UUID id, String title) {
        this.id = id;
        try {
            isBlank(title);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Вы указали некорректное имя");
        }
    }

    public void isBlank(String title) throws IllegalArgumentException {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.title = title;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSpecial() {
        return false;
    }

    public abstract int getPrice();

    @JsonIgnore
    public String getSearchTerm() {
        return getTitle();
    }

    @JsonIgnore
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getNameTerm() {
        return getTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return getTitle();
    }

    @Override
    public int getId() {
        return id.hashCode();
    }

}
