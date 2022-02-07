package com.wrongme.daily.other;

import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量
 * 贪心算法
 */
public class MaxIceCreamSolution {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins - costs[i] >= 0) {
                ans++;
                coins -= costs[i];
                continue;
            }
            break;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxIceCreamSolution solution = new MaxIceCreamSolution();
        System.out.println(solution.maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(solution.maxIceCream(new int[]{10,6,8,7,7,8}, 5));
        System.out.println(solution.maxIceCream(new int[]{1,6,3,1,2,5}, 20));
    }

}
