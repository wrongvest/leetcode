package com.wrongme.offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class MaxSubArraySolution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] sum= new int[n];
        sum[0] = nums[0];
        int ans = sum[0];
        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(nums[i],sum[i-1]+nums[i]);
            ans = Math.max(ans,sum[i]);
        }
        return ans;
    }
}
