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

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    private ProductBasket productBasket;
    private StorageService storageService;
    private BasketService basketService;

    @BeforeEach
    public void setUp() {
        productBasket = new ProductBasket();
    }

    @Test
    public void whenAddProductToBasketIsNot_ThenBasketServiceReturnsResults() {
        UUID id = UUID.randomUUID();
        if (!id.equals(productBasket.getAllBasket().keySet().iterator().next()))
            Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.addProductToBasket(id));
    }

    @Test
    public void whenAddProductToBasketIsExists_ThenBasketServiceReturnsResults() {
        UUID id = UUID.randomUUID();
        if (id.equals(productBasket.getAllBasket().keySet().iterator().next()))
            Assertions.assertDoesNotThrow(() -> basketService.addProductToBasket(id));
    }

    @Test
    public void whenProductBasketIsEmpty_ThenGetUserBasketReturnsIsEmptyBasket() {
        if (productBasket.getAllBasket().isEmpty())
            Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.getUserBasket());
    }

    @Test
    public void whenProductBasketIsNotEmpty_ThenGetUserBasketReturnsIsNotEmptyBasket() {
        if (!(productBasket.getAllBasket().isEmpty()))
            Assertions.assertDoesNotThrow(() -> basketService.getUserBasket());
    }

}
