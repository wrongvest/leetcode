package com.wrongme.daily.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组
 */
public class NumSubarraysWithSumSolution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length + 1;
        int[] dp = new int[n];
        int sum = 0;
        // 前缀和
        for (int i = 0, j = 1; i < nums.length; i++, j++) {
            sum += nums[i];
            dp[j] = sum;
        }
        // 子数组和，出现次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            // 容斥原理
            // 右值
            int right = dp[i + 1];
            // 左值 = 右值 - goal
            int left = right - goal;
            // 0 ->left 的和 出现的次数
            Integer sumLeftCnt = map.getOrDefault(left,0);
            ans = ans + sumLeftCnt;
            map.put(right,map.getOrDefault(right, 0) + 1);
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                if (goal == dp[j]-dp[i]){
//                    ans++;
//                }
//            }
//        }
        return ans;
    }

    public static void main(String[] args) {
        NumSubarraysWithSumSolution solution = new NumSubarraysWithSumSolution();
        System.out.println(solution.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(solution.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }
}
