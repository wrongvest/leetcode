package com.wrongme.daily;

import java.util.*;

public class CountOfAtomsSolution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        Deque<String> deque = new ArrayDeque<>();
        int n = formula.length();
        int idx = 0;
        for (int i = 0; i < n; ) {
            char c = formula.charAt(i);
            if (c == '(' || ')' == c) {
                // 处理括号
                deque.addLast(String.valueOf(c));
                i++;
            } else {
                if (Character.isDigit(c)) {
                    int j = i;
                    while (j < n && Character.isDigit(formula.charAt(j))) {
                        j++;
                    }
                    String num = formula.substring(i, j);
                    i = j;
                    int cnt = Integer.parseInt(num);
                    // 如果栈顶元素是 )，说明当前数值可以应用给「连续一段」的原子中
                    if (!deque.isEmpty() && deque.peekLast().equals(")")) {
                        List<String> list = new ArrayList<>();
                        // 将 ） 弹出
                        deque.pollLast();
                        while (!deque.isEmpty() && !deque.peekLast().equals("(")) {
                            String cur = deque.pollLast();
                            map.put(cur, map.getOrDefault(cur, 1) * cnt);
                            list.add(cur);
                        }
                        // 左括号也弹出来，丢弃
                        deque.pollLast();
                        for (String s : list) {
                            deque.addLast(s);
                        }
                    } else {
                        // 如果栈顶元素是 )，说明没有被括号包裹,直接取出元素
                        String cur = deque.pollLast();
                        map.put(cur, map.getOrDefault(cur, 1) * cnt);
                        deque.addLast(cur);
                    }
                } else {
                    // 获取完整的原子名
                    // 第一个字母大写 跳过
                    int j = i + 1;
                    // 从第二个字母开始一个完整的元素都是小写
                    while (j < n && Character.isLowerCase(formula.charAt(j))) {
                        j++;
                    }
                    // 包含第一个大写字母
                    String cur = formula.substring(i, j) + "_" + (idx++);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                    i = j;
                    deque.addLast(cur);
                }
            }
        }
        // 将不同编号的原子合并
        Map<String, Node> mm = new HashMap<>();
        for (String key : map.keySet()) {
            String atomName = key.split("_")[0];
            Integer cnt = map.get(key);
            Node node = mm.getOrDefault(atomName, new Node(atomName, 0));
            node.v = node.v + cnt;
            mm.put(atomName, node);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.s));
        for (String atom : mm.keySet()) {
            queue.add(mm.get(atom));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            sb.append(node.s);
            if (node.v > 1) {
                sb.append(node.v);
            }
        }
        return sb.toString();
    }

    class Node {
        String s;
        int v;

        Node(String _s, int _v) {
            s = _s;
            v = _v;
        }
    }

    public static void main(String[] args) {
        CountOfAtomsSolution solution = new CountOfAtomsSolution();
        System.out.println(solution.countOfAtoms("Mg(OH)2"));
    }
}
