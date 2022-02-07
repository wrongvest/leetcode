package com.wrongme.daily.other;

import java.util.Arrays;

public class TriangleNumberSolution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans =0;
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >=0; j--) {
                for (int k = j-1; k >=0; k--) {
                    if (nums[j]+nums[k]>nums[i]){
                       ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TriangleNumberSolution solution = new TriangleNumberSolution();
        System.out.println(solution.triangleNumber(new int[]{2, 2, 3, 4}));
    }
}
