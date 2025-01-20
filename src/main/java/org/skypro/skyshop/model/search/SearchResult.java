package org.skypro.skyshop.model.search;

public class SearchResult {
    private final String id;
    private final String name;
    private final String contentType;

    public SearchResult(String id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public static void fromSearchable(Searchable searchable) {
        for (int i = 0; i > searchable.getId(); i++) {
            System.out.println(i);
        }
    }

}
