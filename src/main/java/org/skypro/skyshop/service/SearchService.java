package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public String search(@RequestParam("pattern") String pattern) {
        Set<Searchable> results = storageService.getSearchables().stream()
                .filter(storageService -> storageService.getSearchTerm().equalsIgnoreCase(pattern))
                .collect(Collectors.toSet());
        return results.toString();
    }

}
