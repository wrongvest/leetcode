package com.wrongme.daily.other;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 218. 天际线问题
 */
public class GetSkylineSolution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> ps = new ArrayList<>();
        for (int[] building : buildings) {
            int height = building[2];
            // 左端点为正，右端点为负
            ps.add(new int[]{building[0], -height});
            ps.add(new int[]{building[1], height});
        }
        // 先按横坐标比 ，横坐标相同的情况下，比较高度
        ps.sort((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1] ;
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int pre = 0;
        queue.add(pre);
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] p : ps) {
            int height = p[1];
            if (height < 0) {
                // 左端点，将高度入队
                queue.add(-height);
            } else {
                // 右端点，出队
                queue.remove(height);
            }
            int peek = queue.peek();
            // 如果当前最高度 与 之前矩形高度相同，说明与之前线重合
            if (peek != pre) {
                List<Integer> list = new ArrayList<>(2);
                list.add(p[0]);
                list.add(peek);
                ans.add(list);
                pre = peek;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        GetSkylineSolution solution = new GetSkylineSolution();
        List<List<Integer>> skyline = solution.getSkyline(buildings);
        System.out.println(skyline);
    }
}
