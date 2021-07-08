package com.wrongme.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 1711. 大餐计数
 */
public class CountPairsSolution {
    int mod = (int) 1e9 + 7;
    int max = 1 << 22;

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : deliciousness) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        long count = 0;
        for (Integer x : map.keySet()) {
            for (int i = 0; i < max; i = i << 1) {
                int t = i - x;
                if (map.containsKey(t)) {
                    if (t == x) {
                        count = count + (map.get(x) - 1) * 1L * map.get(x);
                    }else {
                        count = count+ map.get(x)*1L*map.get(t);
                    }
                }
            }
        }
        count>>=1;
        return (int) count % mod;
    }

    public static void main(String[] args) {
//        map.keySet().forEach(System.out::println);
        CountPairsSolution solution = new CountPairsSolution();
        int[] deliciousness = new int[]{1, 3, 5, 7, 9};
        int[] deliciousness2 = new int[]{1, 1, 1, 3, 3, 3, 7};
        int[] deliciousness3 = new int[]{149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234};
//        System.out.println(solution.countPairs(deliciousness));
//        System.out.println(solution.countPairs(deliciousness2));
        System.out.println(solution.countPairs(deliciousness3));
    }
}
