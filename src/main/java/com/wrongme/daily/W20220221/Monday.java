package com.wrongme.daily.W20220221;

/**
 * 2016. 增量元素之间的最大差值
 */
public class Monday {

    public int maximumDifference(int[] nums) {
        int ans = -1;
        int n = nums.length;
        for (int i = 0, min = nums[0]; i < n; i++) {
            if (nums[i] > min) {
                ans = Math.max(ans, nums[i] - min);
            }
            min  = Math.min(min,nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Monday monday = new Monday();
        System.out.println(monday.maximumDifference(new int[]{7, 1, 5, 4}));
        System.out.println(monday.maximumDifference(new int[]{9, 4, 3, 2}));
        System.out.println(monday.maximumDifference(new int[]{1, 5, 2, 10}));
        System.out.println(monday.maximumDifference(new int[]{44, 21, 43, 5, 24}));
    }
}
