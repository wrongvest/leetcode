package com.wrongme.other;

import java.util.*;

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
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (entry1, entry2) -> entry1.getValue().equals(entry2.getValue()) ?
                        entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;

    }
    public List<String> topKFrequent2(String[] words, int k) {
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
