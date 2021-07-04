package com.wrongme.daily;


public class FindErrorNumsSolution {

    public int[] findErrorNums(int[] nums) {
        int[] cnt = new int[nums.length + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        int[] ans = new int[2];
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i]==0){
                ans[1] = i;
            }
            if (cnt[i]==2){
                ans[0] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int nums = new int[]{2,2};

    }
}
