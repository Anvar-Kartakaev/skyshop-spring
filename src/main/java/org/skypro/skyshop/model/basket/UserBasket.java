package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> items;
    private final double total = 0.00;

    public UserBasket(List<BasketItem> items) {
        this.items = items;
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public double getTotal() {
        int count = getItems().size();
        double total = 0.00;
        for (BasketItem item : items) {
            total += item.getProduct().getPrice();
        }
        return count * total;
    }

}
