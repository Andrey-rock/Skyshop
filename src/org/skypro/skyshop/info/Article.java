package org.skypro.skyshop.info;

import org.skypro.skyshop.service.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private final String title;
    private final String content;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
