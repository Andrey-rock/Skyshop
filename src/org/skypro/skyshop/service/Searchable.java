package org.skypro.skyshop.service;

public interface Searchable {
    String getSearchTerm();
    String getType();
    default String getStringRepresentation() {
        return getSearchTerm() + " — " + getType();
    }
}
