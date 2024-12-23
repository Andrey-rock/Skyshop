package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends Exception{
    private final String search;
    public BestResultNotFound(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "Нет наилучшего результата по запросу: " + search;
    }
}
