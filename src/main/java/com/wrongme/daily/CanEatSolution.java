package com.wrongme.daily;

public class CanEatSolution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] answer = new boolean[queries.length];
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; ++i) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        for (int i = 0; i < queries.length; i++) {
            // [favoriteTypei, favoriteDayi, dailyCapi]
            int favoriteType = queries[i][0];
            int favoriteDay = queries[i][1];
            // 每天吃 不超过 dailyCapi 颗糖果
            int dailyCap = queries[i][2];

            long x1 = favoriteDay + 1;
            long y1 = (favoriteDay + 1) * dailyCap;
            long x2 = favoriteType == 0 ? 1 : (sum[favoriteType - 1] + 1);
            long y2 = sum[favoriteType];
            answer[i] = !(x1 > y2 || y1 < x2);
        }

        return answer;
    }

    public static void main(String[] args) {
        CanEatSolution solution = new CanEatSolution();
        int[] candiesCount = new int[]{7, 4, 5, 3, 8};
        int[][] queries = new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}};
        boolean[] answer = solution.canEat(candiesCount, queries);
        for (boolean b : answer) {
            System.out.println(b);
        }
    }
}
