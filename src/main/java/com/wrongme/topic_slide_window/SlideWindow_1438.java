package com.wrongme.topic_slide_window;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 */
public class SlideWindow_1438 {
    // 要求窗口的最大长度，我们必须时刻知道当前窗口内的最值，才能判断是否满足限制。
    // 而此题难点在于当一个元素出窗时，如何以最小的时间开销找到新的窗口内的最大和最小值。
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < nums.length) {
            while (!maxQueue.isEmpty() && nums[right] > maxQueue.peekLast()) {
                maxQueue.removeLast();
            }
            while (!minQueue.isEmpty() && nums[right] < minQueue.peekLast()) {
                minQueue.removeLast();
            }
            maxQueue.addLast(nums[right]);
            minQueue.addLast(nums[right]);
            right++;
            while (maxQueue.peek() - minQueue.peek() > limit) {
                if (maxQueue.peek() == nums[left]) {
                    maxQueue.remove();
                }
                if (minQueue.peek() == nums[left]) {
                    minQueue.remove();
                }
                left = left + 1;
            }
            ans = Math.max(ans,right-left);
        }
        return ans;
    }

    public static void main(String[] args) {
        SlideWindow_1438 slideWindow1438 = new SlideWindow_1438();
        System.out.println(slideWindow1438.longestSubarray(new int[]{8,2,4,7},4));
    }
}
