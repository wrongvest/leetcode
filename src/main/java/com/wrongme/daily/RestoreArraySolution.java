package com.wrongme.daily;

import java.util.*;

public class RestoreArraySolution {

    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        // 出现次数
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, List<Integer>> relationMap = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            cnt.put(adjacentPair[0], cnt.getOrDefault(adjacentPair[0], 0) + 1);
            cnt.put(adjacentPair[1], cnt.getOrDefault(adjacentPair[1], 0) + 1);
            List<Integer> list0 = relationMap.getOrDefault(adjacentPair[0], new ArrayList<>());
            list0.add(adjacentPair[1]);
            relationMap.put(adjacentPair[0], list0);
            List<Integer> list1 = relationMap.getOrDefault(adjacentPair[1], new ArrayList<>());
            list1.add(adjacentPair[0]);
            relationMap.put(adjacentPair[1], list1);
        }
        int start = 0;
        for (Integer integer : cnt.keySet()) {
            if (cnt.get(integer) == 1) {
                start = integer;
                break;
            }
        }
        int[] ans = new int[n];
        ans[0] = start;
        ans[1] = relationMap.get(start).get(0);
        for (int i = 2; i < n; i++) {
            int x = ans[i - 1];
            List<Integer> list = relationMap.get(x);
            for (int integer : list) {
                if (integer != ans[i - 2]) {
                    ans[i] = integer;
                }
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        RestoreArraySolution solution = new RestoreArraySolution();
        System.out.println(Arrays.toString(solution.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}})));
    }

}
