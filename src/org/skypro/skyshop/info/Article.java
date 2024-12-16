package org.skypro.skyshop.info;

import org.skypro.skyshop.service.Searchable;

public final class Article implements Searchable {
    String title;
    String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return title + "\n" + content;
    }

    @Override
    public String getSearchTerm() {
        return this.toString();
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }
}
