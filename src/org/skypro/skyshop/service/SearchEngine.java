package org.skypro.skyshop.service;

import org.skypro.skyshop.exceptions.BestResultNotFound;

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

    public Searchable exactSearch(String search) throws BestResultNotFound {
        int maxRepeat = 0;
        Searchable result = null;
        for (Searchable value : searchable) {
            String str = value.getSearchTerm();
            int count = 0;
            int index = 0;
            int indexSubstring = str.indexOf(search, index);
            while (indexSubstring != -1) {
                count++;
                index = indexSubstring + 1;
                indexSubstring = str.indexOf(search, index);
            }
            if (count > maxRepeat) {
                maxRepeat = count;
                result = value;
            }
        }
        if (result == null) {
            throw new BestResultNotFound(search);
        }
        return result;
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
