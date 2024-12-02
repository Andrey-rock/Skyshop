package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                System.out.println("Продукт добавлен");
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int totalCostBasket() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getCost();
            } else {
                return sum;
            }
        }
        return sum;
    }

    public void printBasket() {
        boolean isBasketEmpty = true;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getCost());
                isBasketEmpty = false;
            }
        }
        if (isBasketEmpty) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + totalCostBasket());
        }
    }

    public boolean isProductExists(String productName) {
        for (Product product : products) {
            if (product != null && product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(products, null);
        System.out.println("Корзина очищена");
    }
}
