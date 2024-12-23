package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.info.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.service.SearchEngine;
import org.skypro.skyshop.service.Searchable;
import java.util.List;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        //Создание продуктов с ошибками
//        try {
//            Product p11 = new SimpleProduct(" ", 30);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            Product p12 = new DiscountedProduct("Чай", -10, 10);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            Product p13 = new SimpleProduct("Кофе", 0);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            Product p14 = new DiscountedProduct("Пельмени", 280, 120);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

        //Создание продуктов
        Product p1 = new FixPriceProduct("Масло");
        Product p2 = new SimpleProduct("Капуста", 30);
        Product p3 = new DiscountedProduct("Чай", 100, 10);
        Product p4 = new SimpleProduct("Кофе", 350);
        Product p5 = new SimpleProduct("Пельмени", 280);
        Product p6 = new DiscountedProduct("Торт", 600, 5);
        System.out.println();

        //Создание статей
        Article a1 = new Article("Чай. История", "Чай китайский и индийский");
        Article a2 = new Article("Пельмени", "Пельмени в русской традиции");
        Article a3 = new Article("Капуста", "Десять блюд из капусты");
        Article a4 = new Article("Кофе. История", "Кофе: арабика и робуста");
        Article a5 = new Article("Чай", "Чай бла бла бла. Чай бла бла бла...");


        //Создание поискового движка
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(a1);
        searchEngine.add(p2);
        searchEngine.add(p2);
        searchEngine.add(p3);
        searchEngine.add(a2);
        searchEngine.add(a3);
        searchEngine.add(a4);
        searchEngine.add(a5);
        searchEngine.add(p1);
        searchEngine.add(p2);
        searchEngine.add(p3);
        searchEngine.add(p3);
        searchEngine.add(p3);
        searchEngine.add(p3);
        searchEngine.add(a3);
        searchEngine.add(p4);
        searchEngine.add(p5);
        searchEngine.add(p2);
        System.out.println();

        //Тест поиска
        System.out.println("Поиск");
        List<Searchable> result1 = searchEngine.search("Капуста");
        List<Searchable> result2 = searchEngine.search("Чай");
        List<Searchable> result3 = searchEngine.search("История");
        Searchable result4 = searchEngine.exactSearch("Чай");
        //Поиск с ошибкой
        System.out.println("Поиск с ошибкой:");
        try {
            Searchable result5 = searchEngine.exactSearch("Апельсин");
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
        System.out.println();

        //Печать результатов поиска
        System.out.println("Результат поиска:");
        System.out.println(result1);
        System.out.println();
        System.out.println(result2);
        System.out.println();
        System.out.println(result3);
        System.out.println();
        System.out.println("Результат поиска самого подходящего элемента Searchable: ");
        System.out.println(result4);
        System.out.println();


        //Создание корзины
        ProductBasket basket = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        //Добавление продуктов в корзину
        System.out.println("Добавление продуктов в корзину");
        basket.addProduct(p1);
        basket.addProduct(p2);
        basket.addProduct(p2);
        basket.addProduct(p3);
        basket.addProduct(p3);
        basket.addProduct(p4);
        basket.addProduct(p5);
        basket.addProduct(p6);
        basket2.addProduct(p6);
        basket2.addProduct(p1);
        basket2.addProduct(p2);
        System.out.println();

        //Печать содержимого корзины
        System.out.println("Содержимое корзины:");
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

        //Удаление продукта из корзины
        System.out.println("Удаление продуктов из корзины: ");
        System.out.println("Удалены: " + basket.removeProduct("Масло"));
        System.out.println("Удалены: " + basket.removeProduct("Капуста"));
        System.out.println();
        System.out.println("Печать корзины: ");
        basket.printBasket();
        System.out.println();

        //Удаление несуществующего продукта из корзины
        System.out.println("Удаление несуществующего продукта из корзины: ");
        if (basket.removeProduct("Арбуз").isEmpty()) {
            System.out.println("Список пуст");
        }
        System.out.println();
        System.out.println("Печать корзины");
        basket.printBasket();


        //Очистка корзины
        basket.clearBasket();
        System.out.println();

        //Вызов методов у пустой корзины
        System.out.println("Стоимость корзины: " + basket.totalCostBasket());
        System.out.println(basket.isProductExists("Масло"));
        basket.printBasket();
    }
}
