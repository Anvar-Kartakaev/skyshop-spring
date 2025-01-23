package org.skypro.skyshop.model.search;

public class SearchResult {
    private final int id;
    private final String name;
    private final String contentType;

    public SearchResult(int id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(searchable.getId(), searchable.getSearchTerm(), searchable.getContentType());
    }

}
