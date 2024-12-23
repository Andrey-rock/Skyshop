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
        int sum = 0;
        for (Map.Entry<String, LinkedList<Product>> entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        int specialProductCount = 0;
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        for (Map.Entry<String, LinkedList<Product>> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().size() + "шт.");
            for (Product product : entry.getValue()) {
                if (product.isSpecial()) {
                    specialProductCount++;
                }
                System.out.println(product);
            }
            System.out.println();
        }
        System.out.println("Итого: " + totalCostBasket());
        System.out.println("Специальных товаров: " + specialProductCount);
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
