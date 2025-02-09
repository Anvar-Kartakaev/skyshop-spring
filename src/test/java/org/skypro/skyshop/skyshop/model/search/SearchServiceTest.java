package org.skypro.skyshop.skyshop.model.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.search.SearchService;
import org.skypro.skyshop.service.StorageService;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    private SearchService searchService;
    private StorageService storageService;
    private Random randomMock;

    @BeforeEach
    void setUp() {
        randomMock = mock(Random.class);
        searchService = new SearchService(storageService);
    }

    @Test
    public void whenPatternIsGiven_ThenSearchServiceReturnsResults(String pattern) {
        when(randomMock.nextBoolean()).thenReturn(true);
        Assertions.assertEquals(searchService.search(pattern), searchService.search(pattern));
    }

    @Test
    public void whenPatternIsNull_ThenSearchServiceReturnsError(String pattern) {
        when(pattern.isBlank()).thenReturn(true);
        Assertions.assertThrows(IllegalArgumentException.class, () -> searchService.search(pattern));
    }

    @Test
    public void whenPatternIsEmpty_ThenSearchServiceReturnsError(String pattern) {
        when(pattern.isEmpty()).thenReturn(true);
        Assertions.assertThrows(IllegalArgumentException.class, () -> searchService.search(pattern));
    }
}
