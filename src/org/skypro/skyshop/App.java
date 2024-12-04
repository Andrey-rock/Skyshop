package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        //Создание продуктов
        Product p1 = new Product("Масло", 150);
        Product p2 = new Product("Капуста", 30);
        Product p3 = new Product("Чай", 100);
        Product p4 = new Product("Кофе", 350);
        Product p5 = new Product("Пельмени", 280);
        Product p6 = new Product("Торт", 600);
        System.out.println();

        //Создание корзины
        ProductBasket basket = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        //Добавление продуктов в корзину
        basket.addProduct(p1);
        basket.addProduct(p2);
        basket.addProduct(p3);
        basket.addProduct(p4);
        basket.addProduct(p5);
        System.out.println();

        basket2.addProduct(p6);
        basket2.addProduct(p2);
        System.out.println();

        //Добавление продуктов в полную корзину
        basket.addProduct(p6);
        System.out.println();

        //Печать содержимого корзины
        basket.printBasket();
        System.out.println();
        basket2.printBasket();
        System.out.println();

        //Получение стоимости корзины
        System.out.println("Стоимость корзины: " + basket.totalCostBasket());

        //Получение стоимости 2-й корзины
        System.out.println("Стоимость корзины №2: " + basket2.totalCostBasket());
        System.out.println();

        //Поиск продукта который есть
        System.out.println(basket.isProductExists("Масло"));
        System.out.println();

        //Поиск продукта которого нет
        System.out.println(basket.isProductExists("Картошка"));
        System.out.println(basket2.isProductExists("Чай"));
        System.out.println();

        //Очистка корзины
        basket.clearBasket();
        System.out.println();

        //Вызов методов у пустой корзины
        System.out.println("Стоимость корзины: " + basket.totalCostBasket());
        System.out.println(basket.isProductExists("Масло"));
        basket.printBasket();
    }
}
