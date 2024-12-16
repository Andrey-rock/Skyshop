package org.skypro.skyshop.service;

public class SearchEngine {
    Searchable[] searchable;

    public SearchEngine(int size) {
        this.searchable = new Searchable[size];
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        for (int i = 0; i < searchable.length; i++) {
            if (searchable[i].getSearchTerm().contains(query)) {
                if (i >= results.length) {
                    break;
                }
                results[i] = searchable[i];
            }
        }
        return results;
    }

    public void add(Searchable search) {
        for (int i = 0; i < this.searchable.length; i++) {
            if (searchable[i] == null) {
                searchable[i] = search;
                break;
            }
        }
    }
}
