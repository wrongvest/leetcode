package com.wrongme.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentSolution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer num = map.get(word);
            if (num == null || num == 0) {
                num = 1;
            } else {
                num += 1;
            }
            map.put(word, num);
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return list.subList(0,k);
    }
}
