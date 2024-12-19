package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice > 0) {
            this.basePrice = basePrice;
        }
        else {
            throw new IllegalArgumentException("Цена должна быть больше нуля");
        }
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        }
        else {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100 процентов");
        }
    }

    @Override
    public int getPrice() {
        return basePrice * (100 - discount) / 100;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
