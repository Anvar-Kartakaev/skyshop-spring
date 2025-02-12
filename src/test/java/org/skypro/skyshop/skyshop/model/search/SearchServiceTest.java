package org.skypro.skyshop.skyshop.model.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.search.SearchService;
import org.skypro.skyshop.service.StorageService;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private SearchService searchService;
    private StorageService storageService;

    @Test
    public void whenPatternIsGiven_ThenSearchServiceReturnsResults() {
        String pattern = "test";
        Assertions.assertEquals(searchService.search(pattern), searchService.search(pattern));
    }

    @Test
    public void whenPatternIsNull_ThenSearchServiceReturnsError() {
        String pattern = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> searchService.search(null));
    }

    @Test
    public void whenPatternIsEmpty_ThenSearchServiceReturnsError() {
        String pattern = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> searchService.search(pattern));
    }
}
