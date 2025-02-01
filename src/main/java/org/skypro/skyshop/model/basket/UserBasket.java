package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> items;
    private final double total;

    public UserBasket(List<BasketItem> items) {
        this.items = items;
        double sum = items.stream().mapToDouble(x -> x.getProduct().getPrice()).sum();
        int counts = items.stream().mapToInt(BasketItem::getCount).sum();
        this.total = sum * counts;
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

}
