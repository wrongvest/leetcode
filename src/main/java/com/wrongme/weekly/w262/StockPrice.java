package com.wrongme.weekly.w262;


import java.util.*;

public class StockPrice {
    private int cur = -1;
    private Map<Integer, Integer> map = new HashMap<>();
    private Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.price-o1.price;
        }
    });

    public StockPrice() {
    }

    public void update(int timestamp, int price) {
        Integer p = map.get(timestamp);
        map.put(timestamp, price);
        if (timestamp > this.cur) {
            this.cur = timestamp;
        }
        if (p != null) {
            queue.remove(new Node(timestamp, price));
        }
        queue.add(new Node(timestamp, price));
    }

    public int current() {
        return map.get(this.cur);
    }

    public int maximum() {
        return queue.peek().price;
    }

    public int minimum() {
        Queue<Node> queue2 = new PriorityQueue<>();
        Node temp = null;
        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue2.add(queue.poll());
        }
        queue =queue2;
        return temp.price;
    }

    class Node {
        int timestamp;
        int price;

        public Node(int timestamp, int price) {
            this.timestamp = timestamp;
            this.price = price;
        }
    }


    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4, 2);
        System.out.println(stockPrice.minimum());
    }
}
