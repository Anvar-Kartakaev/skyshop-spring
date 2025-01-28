package org.skypro.skyshop.model.product;

import java.util.Objects;
import java.util.UUID;

public class FixPriceProduct extends Product {
    public static final int FIX_PRICE = 77;

    public FixPriceProduct(UUID id, String title){
        super(id, title);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixPriceProduct product = (FixPriceProduct) o;
        return getTitle().equals(product.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }

    @Override
    public String toString() {
        return getTitle() + ": Фиксированная цена " + getPrice() + " рублей.";
    }

}