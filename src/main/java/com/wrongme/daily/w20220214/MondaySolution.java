package com.wrongme.daily.w20220214;

/**
 * 540. 有序数组中的单一元素
 */
public class MondaySolution {
    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i=i+2) {
            if (nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[ nums.length-1];
    }

    public static void main(String[] args) {
        MondaySolution solution =new MondaySolution();
        System.out.println(solution.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }
}
