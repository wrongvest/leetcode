package com.wrongme.topic_slide_window;

import java.util.TreeSet;

/**
 * 滑动窗口
 * 220. 存在重复元素 III
 */
public class SlideWindows_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long u= (long) nums[i];
            Long left = set.floor(u); // u 左边 最接近u的数 Returns the greatest key less than or equal to the given key,
            Long right = set.ceiling(u);  // u 右边 最接近u的数 Returns the least key greater than or equal to the given key,

            if (left!=null && u -left <=t){
                return true;
            }

            if (right!=null && right - u<=t){
                return true;
            }
            set.add(u);
            if (i>=k){
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SlideWindows_220 slideWindows_220 = new SlideWindows_220();
        System.out.println(slideWindows_220.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
    }
}
