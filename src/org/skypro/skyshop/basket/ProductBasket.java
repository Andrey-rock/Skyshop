package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    //Выбираем HashMap для хранения продуктов
    private final HashMap<String, LinkedList<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), (k -> new LinkedList<>())).
                add(product);
        System.out.println("Продукт добавлен");
    }

    public int totalCostBasket() {
        return products.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        products.values().stream().flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + totalCostBasket());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private int getSpecialCount() {
        return (int) products.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }


    public boolean isProductExists(String productName) {
        return products.containsKey(productName);
    }

    public void clearBasket() {
        products.clear();
        System.out.println("Корзина очищена");
    }

    public List<Product> removeProduct(String name) {
        List<Product> removedProducts = products.get(name);
        products.remove(name);
        return removedProducts == null ? Collections.emptyList() : removedProducts;
    }
}
