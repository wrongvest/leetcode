package com.wrongme.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 */
public class FrequencySort {

    class Node {
        char c;
        int v;

        public Node(char c, int v) {
            this.c = c;
            this.v = v;
        }
    }

    private Map<Character, Integer> map = new HashMap<>();

    public String frequencySort(String s) {
        if (s == null) {
            return "";
        }
        if (s.length() <= 2) {
            return s;
        }
        // 统计个数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.v != o2.v) {
                return o2.v - o1.v;
            }
            return o1.c - o2.c;
        });
        map.forEach((k, v) -> {
            queue.add(new Node(k, v));
        });
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int v = poll.v;
            while (v-- > 0) {
                sb.append(poll.c);
            }
        }
        return sb.toString();
    }

//    public String frequencySort1(String s) {
//
//    }
}
