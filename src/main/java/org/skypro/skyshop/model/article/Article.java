package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private final UUID id;
    private final String articleTitle;
    private final String articleDescription;

    public Article(UUID id, String articleTitle, String articleDescription) {
        this.id = id;
        this.articleTitle = articleTitle;
        this.articleDescription = articleDescription;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public String toString() {
        return getArticleTitle() + " - " + getArticleDescription();
    }

    @Override
    public int getId() {
        return id.hashCode();
    }

    @JsonIgnore
    public String getSearchTerm() {
        return getArticleTitle();
    }

    @JsonIgnore
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getNameTerm() {
        return getArticleTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id.equals(article.id) ^ articleTitle.equals(article.articleTitle);
    }

    @Override
    public int hashCode() {
        return id.hashCode() ^ articleTitle.hashCode();
    }

}