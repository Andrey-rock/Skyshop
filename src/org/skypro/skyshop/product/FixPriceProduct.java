package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private final static int FIX_PRICE = 99;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
