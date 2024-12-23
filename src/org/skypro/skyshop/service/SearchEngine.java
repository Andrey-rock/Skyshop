package org.skypro.skyshop.service;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    List<Searchable> searchable = new ArrayList<>();

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable value : searchable) {
            if (value.getSearchTerm().contains(query)) {
                results.put(value.getSearchTerm(), value);
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
        searchable.add(search);
    }
}
