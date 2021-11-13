package com.wrongme.weekly.w262;

public class MinMovesSolution {
    // 选出n-1个增加1<======>剩下那个减少1
    public int minMoves(int[] nums) {
        int small = nums[0];
        for (int num : nums) {
            small = Math.min(small,num);
        }
        int ans = 0;
        for (int num : nums) {
            ans = ans+(num-small);
        }
        return ans;
    }
}
