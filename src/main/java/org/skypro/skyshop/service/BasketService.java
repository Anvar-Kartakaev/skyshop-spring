package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;

import java.util.*;
import java.util.stream.Collectors;

public class BasketService {
    private final ProductBasket basketId;
    private final StorageService storageService;

    public BasketService(ProductBasket basketId, StorageService storageService) {
        this.basketId = basketId;
        this.storageService = storageService;
    }

    public ProductBasket getBasketId() {
        return basketId;
    }

    public StorageService getStorageService() {
        return storageService;
    }

    public void addProductToBasket(UUID id) {
        if (storageService.getProductById(id).isPresent()) {
            throw new IllegalArgumentException("Товар отсутствует!");
        } else {
            basketId.addProduct(id);
        }
    }

    public UserBasket getUserBasket() {
        return null;
    }

}
