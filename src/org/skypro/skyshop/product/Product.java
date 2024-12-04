package org.skypro.skyshop.product;

public class Product {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
