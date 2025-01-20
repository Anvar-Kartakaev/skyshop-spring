package org.skypro.skyshop.controller.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public SearchResult search(String keyword) {
        Set<Searchable> searchables = storageService.getSearchables().stream()
                .filter(storageService -> storageService.getSearchTerm().equalsIgnoreCase(keyword))
                .collect(Collectors.toSet());
        return (SearchResult) searchables;
    }

}
