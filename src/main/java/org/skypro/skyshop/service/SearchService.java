package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Set<SearchResult> search(String pattern) {
        return (Set<SearchResult>) storageService.getSearchable().stream()
                .filter(searchable -> searchable.getSearchTerm().equalsIgnoreCase(pattern));
    }

}
