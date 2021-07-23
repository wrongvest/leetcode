package com.wrongme.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 */
public class IsCoveredSolution {

    public boolean isCovered(int[][] ranges, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            list.add(i);
        }
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < ranges.length; j++) {
            for (int i = ranges[j][0]; i <= ranges[j][1]; i++) {
                set.add(i);
            }
        }
        int size = 0;
        for (int i : list) {
            if (set.contains(i)) {
                size++;
            }
        }
        return list.size() == size;
    }

    public static void main(String[] args) {
        IsCoveredSolution solution = new IsCoveredSolution();
        System.out.println(solution.isCovered(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 8));
        System.out.println(solution.isCovered(new int[][]{{1, 10}, {10, 20}}, 21, 21));
        System.out.println(solution.isCovered(new int[][]{{1, 50}, {10, 20}}, 1, 50));
    }
}
