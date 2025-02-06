package org.skypro.skyshop.service;

import org.skypro.skyshop.controller.NoSuchProductException;
import org.skypro.skyshop.controller.ShopError;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;
    private final ShopError shopError;

    public BasketService(ProductBasket productBasket, StorageService storageService, ShopError shopError) {
        this.productBasket = productBasket;
        this.storageService = storageService;
        this.shopError = shopError;
    }

    public ProductBasket getProductBasket() {
        return productBasket;
    }

    public StorageService getStorageService() {
        return storageService;
    }

    public ShopError getShopError() {
        return shopError;
    }

    public void addProductToBasket(UUID id) {
        Optional<Product> productOptional = getStorageService().getProductById(id);
        if (!productOptional.isPresent()) {
            throw new NoSuchProductException();
        } else {
            productBasket.addProduct(id);
        }
    }

    public UserBasket getUserBasket() {
        List<BasketItem> basketItem = getProductBasket().getAllBasket().entrySet().stream()
                .map(entry -> new BasketItem(getStorageService().getAllProducts().get(entry.getKey()), entry.getValue()))
                .collect(Collectors.toList());
        return new UserBasket(basketItem);
    }

}
