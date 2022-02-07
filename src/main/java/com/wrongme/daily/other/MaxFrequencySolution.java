package com.wrongme.daily.other;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 */
public class MaxFrequencySolution {
    int n;
    int[] sum;
    int target;

    public int maxFrequency(int[] nums, int k) {
        target = k;
        Arrays.sort(nums);
        this.n = nums.length;
        sum = new int[this.n + 1];
        for (int i = 1; i <= this.n; i++) {
            sum[this.n] = sum[i - 1] + nums[i - 1];
        }
        int left = 0, right = this.n;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(mid, nums)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(int len, int[] nums) {
        for (int left = 0; left + len - 1 < this.n; left++) {
            int right = left + len - 1;
            int cur = sum[right + 1] - sum[left];
            int t = nums[right] * len;
            if (t - cur <= target) {
                return true;
            }
        }
        return false;
    }

}
