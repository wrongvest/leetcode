package com.wrongme.daily.w20220207;

public class SolutionWednesday {
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i]-nums[j])==k){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SolutionWednesday wednesday = new SolutionWednesday();
        System.out.println(wednesday.countKDifference(new int[]{1, 2, 2, 1}, 1));
        System.out.println(wednesday.countKDifference(new int[]{1, 3}, 3));
        System.out.println(wednesday.countKDifference(new int[]{3,2,1,5,4}, 2));
    }
}
