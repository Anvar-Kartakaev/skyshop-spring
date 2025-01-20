package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

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

}