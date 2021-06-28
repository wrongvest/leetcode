package com.wrongme.bfs;

import java.util.*;

/**
 * 815. 公交路线
 */
public class NumBusesToDestinationSolution {

    private int[][] rs;
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        rs = routes;
        return bfs(source, target);
    }

    private int bfs(int source, int target) {
        // 记录某个车站可以进入的路线
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 队列是经过的路线
        Deque<Integer> d = new ArrayDeque<>();
        // 进入该路线所使用的距离
        Map<Integer, Integer> distanceMap = new HashMap<>();
        int n = rs.length;
        for (int i = 0; i < n; i++) {
            for (int station : rs[i]) {
                // 将从起点可以进入的路线加入队列
                if (station == source) {
                    // i 第i号线，rs[i]
                    d.addLast(i);
                    distanceMap.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                set.add(i);
                map.put(station, set);
            }
        }
        while (!d.isEmpty()) {
            // 取出当前所在的线路
            Integer line = d.pollFirst();
            if (line == null) {
                return -1;
            }
            // 取出到达当前所在线路花费的距离
            int distance = distanceMap.get(line);
            // 遍历当前线路包含的车站
            for (int station : rs[line]) {
                // 如果当前路线包含终点，返回进入该路线花费的距离即可
                if (station == target) {
                    return distance;
                }
                // 将由该线路的车站发起的路线，加入队列
                Set<Integer> lines = map.get(station);
                if (lines == null || lines.isEmpty()) {
                    continue;
                }
                for (Integer lin : lines) {
                    if (!distanceMap.containsKey(lin)){
                        distanceMap.put(lin,distance+1);
                        d.addLast(lin);
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] routes = new int[][]{{1, 2, 7}, {3, 6, 7}, {3, 8, 9}};
        NumBusesToDestinationSolution solution = new NumBusesToDestinationSolution();
        System.out.println(solution.numBusesToDestination(routes, 1, 9));
    }
}

