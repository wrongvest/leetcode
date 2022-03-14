package com.wrongme.daily.w20220308;

import java.util.*;

/***
 * 599. 两个列表的最小索引总和
 */
public class Wednesday {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> ansList = new LinkedList<>();
        for (int i = 0; i < list2.length; i++) {
            Integer index = map.get(list2[i]);
            if (index==null){
                continue;
            }
            if (min == i + index) {
                ansList.add(list2[i]);
            }else if (min > i + index){
                min = i + index;
                ansList.clear();
                ansList.add(list2[i]);
            }
        }
        return ansList.toArray(new String[ansList.size()]);
    }

    public static void main(String[] args) {
        Wednesday wednesday  = new Wednesday();
        Arrays.stream(wednesday.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})).forEach(System.out::println);

    }
}
