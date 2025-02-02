package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> items;
    private final double total;

    public UserBasket(List<BasketItem> items) {
        this.items = items;
        this.total = items.stream().mapToDouble(p -> p.getProduct().getPrice() * p.getCount()).sum();
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

}
