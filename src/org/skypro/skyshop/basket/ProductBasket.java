package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    //Выбираем LinkedList т.к. не нужен доступ по индексу и удаление будет производиться с помощью Итератора.
    private final List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Продукт добавлен");
    }

    public int totalCostBasket() {
        int sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    public void printBasket() {
        int specialProductCount = 0;
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        for (Product product : products) {
            if (product.isSpecial()) {
                specialProductCount++;
            }
            System.out.println(product);
        }
        System.out.println("Итого: " + totalCostBasket());
        System.out.println("Специальных товаров: " + specialProductCount);
    }


    public boolean isProductExists(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
        System.out.println("Корзина очищена");
    }

    public List<Product> removeProduct(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}
