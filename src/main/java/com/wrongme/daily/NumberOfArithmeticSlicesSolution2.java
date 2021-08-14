package com.wrongme.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 446. 等差数列划分 II - 子序列
 */
public class NumberOfArithmeticSlicesSolution2 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        // 每个 f[i] 均为哈希表，哈希表键值对为 {d : cnt}
        // d : 子序列差值
        // cnt : 以 nums[i] 为结尾，且差值为 d 的子序列数量
        List<Map<Long,Integer>> f = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map<Long,Integer> cur= new HashMap<>();
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] -nums[j];
                Map<Long, Integer> prev = f.get(j);
                int cnt = cur.getOrDefault(d, 0);
                cnt += prev.getOrDefault(d,0);
                cnt++;
                cur.put(d,cnt);
            }
            f.add(cur);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Long, Integer> cur = f.get(i);
            for (Long key : cur.keySet()) {
                ans += cur.get(key);
            }
        }
        int cnt = (n -1)*n/2;
        return ans-cnt;
    }
}
