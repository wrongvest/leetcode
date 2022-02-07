package com.wrongme.daily.other;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1418. 点菜展示表
 */
public class DisplayTableSolution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> menus = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (List<String> order : orders) {
            String table = order.get(1);
            String dishName = order.get(2);
            menus.add(dishName);
            String key = table + "_" + dishName;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<String> m = new ArrayList<>(menus);
        Collections.sort(m);
        List<String> title = new ArrayList<>();
        title.add("Table");
        title.addAll(m);
        // 菜名，排序值
        Map<String, Integer> menuOrderMap = new HashMap<>();
        for (int i = 0; i < title.size(); i++) {
            menuOrderMap.put(title.get(i), i);
        }
        Map<Integer, List<String>> resultMap = new HashMap<>();
        for (String key : map.keySet()) {
            int cnt = map.get(key);
            String table = key.split("_")[0];
            String dishName = key.split("_")[1];
            int index = menuOrderMap.get(dishName);
            List<String> list = resultMap.get(Integer.valueOf(table));
            if (list == null) {
                list = new ArrayList<>();
                for (int i = 0; i < title.size(); i++) {
                    list.add("0");
                }
            }
            list.set(index, cnt + "");
            resultMap.put(Integer.valueOf(table),list);
        }
        List<Integer> tables = new ArrayList<>(resultMap.keySet());
        Collections.sort(tables);
        List<List<String>> result = new ArrayList<>();
        result.add(title);
        for (Integer table : tables) {
            List<String> list = resultMap.get(table);
            list.set(0,table+"");
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> orders = new ArrayList<>();
        String[] str1 = new String[]{"David", "3", "Ceviche"};
        String[] str2 = new String[]{"Corina", "10", "Beef Burrito"};
        String[] str3 = new String[]{"David", "3", "Fried Chicken"};
        String[] str4 = new String[]{"Carla", "5", "Water"};
        String[] str5 = new String[]{"Carla", "5", "Ceviche"};
        String[] str6 = new String[]{"Rous", "3", "Ceviche"};
        orders.add(Arrays.stream(str1).collect(Collectors.toList()));
        orders.add(Arrays.stream(str2).collect(Collectors.toList()));
        orders.add(Arrays.stream(str3).collect(Collectors.toList()));
        orders.add(Arrays.stream(str4).collect(Collectors.toList()));
        orders.add(Arrays.stream(str5).collect(Collectors.toList()));
        orders.add(Arrays.stream(str6).collect(Collectors.toList()));
        DisplayTableSolution solution = new DisplayTableSolution();
        List<List<String>> lists = solution.displayTable(orders);
        System.out.println(lists);
    }
}
