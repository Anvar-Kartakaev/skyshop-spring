package org.skypro.skyshop.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    private ProductBasket productBasket;
    private StorageService storageService;
    private BasketService basketService;

    @BeforeEach
    public void setUp() {
        productBasket = new ProductBasket();
    }

    @Test
    public void whenAddProductToBasketIsNot_ThenBasketServiceReturnsResults(UUID id) {
        when(id.equals(storageService.getProductById(id))).thenReturn(false);
        Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.addProductToBasket(id));
    }

    @Test
    public void whenAddProductToBasketIsExists_ThenBasketServiceReturnsResults(UUID id) {
        when(id.equals(storageService.getProductById(id))).thenReturn(true);
        Assertions.assertDoesNotThrow(() -> basketService.addProductToBasket(id));
    }

    @Test
    public void whenProductBasketIsEmpty_ThenGetUserBasketReturnsIsEmptyBasket() {
        when(productBasket.getAllBasket().isEmpty()).thenReturn(true);
        Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.getUserBasket());
    }

    @Test
    public void whenProductBasketIsNotEmpty_ThenGetUserBasketReturnsIsNotEmptyBasket() {
        when(productBasket.getAllBasket().equals(basketService.getUserBasket())).thenReturn(true);
        Assertions.assertEquals(basketService.getUserBasket(), productBasket);
    }

}
