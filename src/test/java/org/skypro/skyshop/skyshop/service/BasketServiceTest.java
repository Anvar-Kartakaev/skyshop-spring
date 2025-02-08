package org.skypro.skyshop.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    private ProductBasket productBasket;
    @Mock
    private StorageService storageService;
    @Mock
    private BasketService basketService;

    public BasketServiceTest(ProductBasket productBasket, StorageService storageService, BasketService basketService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
        this.basketService = basketService;
    }

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void whenAddProductToBasketIsNot_ThenBasketServiceReturnsResults(UUID id) {
        when(!(storageService.getProductById(id).equals(id))).thenReturn(true);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {});
    }

    @Test
    public void whenAddProductToBasketIsExists_ThenBasketServiceReturnsResults(UUID id) {
        when(id.equals(productBasket.getAllBasket().get(id))).thenReturn(true);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {});
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
