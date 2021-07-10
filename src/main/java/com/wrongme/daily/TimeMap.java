package com.wrongme.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 981. 基于时间的键值存储
 */
public class TimeMap {
    class Node {
        String key;
        String value;
        int timestamp;

        public Node(String key, String value, int timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, PriorityQueue<Node>> map;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        PriorityQueue<Node> queue = map.getOrDefault(key, new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp));
        queue.add(new Node(key, value, timestamp));
        map.put(key, queue);
    }

    public String get(String key, int timestamp) {
        PriorityQueue<Node> queue = map.get(key);
        if (queue == null || queue.isEmpty()) {
            return "";
        }
        queue.size();
        Node poll = queue.peek();
        if (poll.timestamp <= timestamp) {
            return poll.value;
        }
        return "";
    }

    public static void main(String[] args) {
        TimeMap kv = new TimeMap();
        kv.set("love", "high", 10);
        kv.set("love", "low", 20);
        kv.set("love", "low2", 30);
        kv.get("love", 5);
        kv.get("love", 10);
        kv.get("love", 15);
        kv.get("love", 20);
        kv.get("love", 25);
    }
}
