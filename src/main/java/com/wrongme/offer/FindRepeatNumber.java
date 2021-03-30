package com.wrongme.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 2021年3月30日22:20:52
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                return num;
            }
        }
        return 0;
    }
}
