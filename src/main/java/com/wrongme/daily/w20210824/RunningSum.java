package com.wrongme.daily.w20210824;

public class RunningSum {
    public int[] runningSum(int[] nums) {
//        int[] ans = new int[nums.length];
//        ans[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i]= nums[i-1]+nums[i];
        }
        return nums;
    }
}
