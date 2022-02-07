package com.wrongme.daily.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMaxFormSolution {
    public static int findMaxForm(String[] strs, int m, int n) {
        List<Integer> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            Integer integer = Integer.valueOf(strs[i]);
            int bitNum = countNum(strs[i]);
            if (bitNum <= n && strs[i].length() - bitNum <= m) {
                map.put(strs[i],integer);
            }
        }
//        map.v
        int i=0;
        list.forEach(integer -> {

        });
        return list.size();
    }

    private static int countNum(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strs1 = new String[]{"10","0001","111001","1","0"};
        String[] strs2 = new String[]{"10", "1", "0"};
        System.out.println(findMaxForm(strs1, 5, 3));
        System.out.println(findMaxForm(strs2, 1, 1));
    }

}
