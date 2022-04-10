package com.wrongme.topic_slide_window;

import java.util.Arrays;

public class SlideWindows_1984 {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        // i 指向右边
        int ans = Integer.MAX_VALUE;
        for (int i = k; i <= nums.length; i++) {
            int dif =  nums[i-1] -nums[i-k];
            ans = Math.min(ans,dif);
        }
        return ans;
    }

    public static void main(String[] args) {
        SlideWindows_1984 slideWindows_1984 = new SlideWindows_1984();
        System.out.println(slideWindows_1984.minimumDifference(new int[]{9, 4, 1, 7}, 2));
        System.out.println(slideWindows_1984.minimumDifference(new int[]{90}, 1));
    }

}
