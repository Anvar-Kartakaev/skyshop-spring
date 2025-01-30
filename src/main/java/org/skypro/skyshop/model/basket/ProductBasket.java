package org.skypro.skyshop.model.basket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductBasket {
    private final Map<UUID, Integer> basket;

    public ProductBasket(UUID id, Integer quantity) {
        this.basket = new HashMap<>();
        this.basket.put(id, quantity);
    }

    public Integer getQuantity(UUID id) {
        return this.basket.get(id);
    }

    public void addProduct(UUID id) {
        basket.put(id, getQuantity(id) + 1);
    }

    public Map<UUID, Integer> getAllBasket() {
        return Collections.unmodifiableMap(basket);
    }
}
