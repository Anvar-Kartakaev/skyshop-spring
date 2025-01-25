package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Set<Searchable> search(String pattern) {
        return storageService.getSearchable().stream()
                .filter(searchable -> searchable.getSearchTerm().equalsIgnoreCase(pattern))
                .collect(Collectors.toSet());
    }

}
