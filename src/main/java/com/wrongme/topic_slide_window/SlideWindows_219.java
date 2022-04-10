package com.wrongme.topic_slide_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlideWindows_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            if (i >= k) {
                set.remove(nums[i - k]);
            }
            set.add(nums[i]);
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length < k) {
            k = nums.length - 1;
        }
        // 初始化窗口
        for (int i = 0; i < k; i++) {
            Integer v = map.get(nums[i]);
            if (v != null) {
                return true;
            }
            map.put(nums[i], 1);
        }
        // 开始滑动
        for (int i = k; i < nums.length; i++) {
            Integer v = map.get(nums[i]);
            if (v != null) {
                return true;
            }
            // 把窗口最前面的移走
            map.remove(nums[i - k]);
            map.put(nums[i], 1);
        }
        return false;
    }

    public static void main(String[] args) {
        SlideWindows_219 slideWindows_219 = new SlideWindows_219();
        System.out.println(slideWindows_219.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(slideWindows_219.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(slideWindows_219.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(slideWindows_219.containsNearbyDuplicate(new int[]{1, 2, 1}, 0));
        System.out.println(slideWindows_219.containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15));
    }

}
