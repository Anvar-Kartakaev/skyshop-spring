package org.skypro.skyshop.model.search;

import org.skypro.skyshop.service.SearchResult;
import org.skypro.skyshop.service.StorageService;
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

    public Set<SearchResult> search(String pattern) {
        Set<Searchable> result = storageService.getSearchable().stream().collect(Collectors.toSet());
        Set<SearchResult> searchResults = new HashSet<>();
        for (Searchable searchable : result) {
            searchResults.add(new SearchResult(searchable.getId(), searchable.getNameTerm(), searchable.getContentType()));
        }
        return searchResults.stream().filter(searchResult -> searchResult.getName().equalsIgnoreCase(pattern)).collect(Collectors.toSet());
    }

}
