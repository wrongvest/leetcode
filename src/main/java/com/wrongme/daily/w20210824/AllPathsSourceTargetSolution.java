package com.wrongme.daily.w20210824;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsSourceTargetSolution {
    int n = 0;
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        cur.add(0);
        dfs(graph, 0);
        return ans;
    }

    private void dfs(int[][] graph, int i) {
        if (i == n - 1) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int j = 0; j < graph[i].length; j++) {
            if (cur.contains(graph[i][j])) {
                continue;
            }
            cur.add(graph[i][j]);
            dfs(graph, graph[i][j]);
            cur.remove(cur.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        AllPathsSourceTargetSolution solution = new AllPathsSourceTargetSolution();
        solution.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3},{}});
    }
}
