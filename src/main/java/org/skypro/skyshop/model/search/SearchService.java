package org.skypro.skyshop.model.search;

import org.skypro.skyshop.service.SearchResult;
import org.skypro.skyshop.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Set<SearchResult> search(String pattern) {
        return storageService.getSearchable().stream()
                .map(SearchResult::fromSearchable)
                .filter(searchResult -> searchResult.getName().equalsIgnoreCase(pattern))
                .collect(Collectors.toSet());
    }

}
