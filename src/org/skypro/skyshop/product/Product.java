package org.skypro.skyshop.product;

import org.skypro.skyshop.service.Searchable;

public abstract class Product implements Searchable {
    protected String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }
}
