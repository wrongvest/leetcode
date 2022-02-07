package com.wrongme.daily.other;

public class FindTargetSumWaysSolution {
    static public int findTargetSumWays(int[] nums, int t) {
        return dfs(nums, t, 0, 0);
    }
    static private int dfs(int[] nums, int t, int u, int cur) {
        if (u == nums.length) {
            return cur == t ? 1 : 0;
        }
        int left = dfs(nums, t, u + 1, cur + nums[u]);
        int right = dfs(nums, t, u + 1, cur - nums[u]);
        return left + right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        findTargetSumWays(nums,target);
    }
}
