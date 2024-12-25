package org.skypro.skyshop.service;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    Set<Searchable> searchable = new HashSet<>();

    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>((o1, o2) -> {
            int result = Integer.compare(o2.getSearchTerm().length(), o1.getSearchTerm().length());
            if (result == 0) {
                return o1.getSearchTerm().compareTo(o2.getSearchTerm());
            }
            return result;
        });

        for (Searchable value : searchable) {
            if (value.getSearchTerm().contains(query)) {
                results.add(value);
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
