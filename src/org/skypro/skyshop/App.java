package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.info.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.service.SearchEngine;
import org.skypro.skyshop.service.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //Создание продуктов
        Product p1 = new FixPriceProduct("Масло");
        Product p2 = new SimpleProduct("Капуста", 30);
        Product p3 = new DiscountedProduct("Чай", 100, 10);
        Product p4 = new SimpleProduct("Кофе", 350);
        Product p5 = new SimpleProduct("Пельмени", 280);
        Product p6 = new DiscountedProduct("Торт", 600, 5);
        System.out.println();

        //Создание статей
        Article a1 = new Article("Чай. История", "чай китайский и индийский");
        Article a2 = new Article("Пельмени", "Пельмени в русской традиции");
        Article a3 = new Article("Капуста", "Десять блюд из капусты");
        Article a4 = new Article("Кофе. История", "Кофе: арабика и робуста");

       //Создание поискового движка
        SearchEngine searchEngine = new SearchEngine(7);
        searchEngine.add(a1);
        searchEngine.add(a2);
        searchEngine.add(a3);
        searchEngine.add(a4);
        searchEngine.add(p1);
        searchEngine.add(p2);
        searchEngine.add(p3);
        searchEngine.add(p4);
        searchEngine.add(p5);
        searchEngine.add(p6);
        System.out.println();

        //Тест поиска
        Searchable[] result1 = searchEngine.search("Капуста");
        Searchable[] result2 = searchEngine.search("чай");
        Searchable[] result3 = searchEngine.search("История");

        //Печать результатов поиска
        System.out.println(Arrays.toString(result1));
        System.out.println();
        System.out.println(Arrays.toString(result2));
        System.out.println();
        System.out.println(Arrays.toString(result3));


//        //Создание корзины
//        ProductBasket basket = new ProductBasket();
//        ProductBasket basket2 = new ProductBasket();
//
//        //Добавление продуктов в корзину
//        basket.addProduct(p1);
//        basket.addProduct(p2);
//        basket.addProduct(p3);
//        basket.addProduct(p4);
//        basket.addProduct(p5);
//        System.out.println();
//
//        basket2.addProduct(p6);
//        basket2.addProduct(p2);
//        System.out.println();
//
//        //Добавление продуктов в полную корзину
//        basket.addProduct(p6);
//        System.out.println();
//
//        //Печать содержимого корзины
//        basket.printBasket();
//        System.out.println();
//        basket2.printBasket();
//        System.out.println();
//
//        //Получение стоимости корзины
//        System.out.println("Стоимость корзины: " + basket.totalCostBasket());
//
//        //Получение стоимости 2-й корзины
//        System.out.println("Стоимость корзины №2: " + basket2.totalCostBasket());
//        System.out.println();
//
//        //Поиск продукта который есть
//        System.out.println(basket.isProductExists("Масло"));
//        System.out.println();
//
//        //Поиск продукта которого нет
//        System.out.println(basket.isProductExists("Картошка"));
//        System.out.println(basket2.isProductExists("Чай"));
//        System.out.println();
//
//        //Очистка корзины
//        basket.clearBasket();
//        System.out.println();
//
//        //Вызов методов у пустой корзины
//        System.out.println("Стоимость корзины: " + basket.totalCostBasket());
//        System.out.println(basket.isProductExists("Масло"));
//        basket.printBasket();
    }
}
