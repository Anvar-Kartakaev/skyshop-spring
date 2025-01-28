package org.skypro.skyshop.model.product;

import java.util.Objects;
import java.util.UUID;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountPercentage;

    public DiscountedProduct(UUID id, String title, int basePrice, int discountPercentage) {
        super(id, title);
        try {
            checking(basePrice, discountPercentage);
        } catch (IllegalArgumentException s) {
            throw new IllegalArgumentException("Некорректные данные для товара: " + title, s);
        }
    }

    public void checking(int basePrice, int discountPercentage) throws IllegalArgumentException {
        if (basePrice < 1) {
            throw new IllegalArgumentException("Стоимость товара не может быть 0 руб. или с отрицательным значением.");
        } if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Скидка можно установить в диапазоне от 0% до 100%.");
        } else {
            this.basePrice = basePrice;
            this.discountPercentage = discountPercentage;
        }
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public int getPrice() {
        return ((100 - discountPercentage) * basePrice) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountedProduct product = (DiscountedProduct) o;
        return basePrice == product.basePrice && discountPercentage == product.discountPercentage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(basePrice, discountPercentage);
    }

    @Override
    public String toString() {
        return getTitle() + ": " + getPrice() + " рублей." + " Скидка (" + getDiscountPercentage() + "%)";
    }

}