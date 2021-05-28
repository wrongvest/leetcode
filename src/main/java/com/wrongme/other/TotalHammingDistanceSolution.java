package com.wrongme.other;

public class TotalHammingDistanceSolution {
    public int totalHammingDistance(int[] nums) {
        int distance = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                distance = distance + hammingDistance(nums[i], nums[j]);
            }
        }
        return distance;
    }

    int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                distance++;
            }
            xor = xor >> 1;
        }
        return distance;
    }
}
