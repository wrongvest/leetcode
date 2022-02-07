package com.wrongme.daily.other;

import java.util.Arrays;

public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);
        int n = nums.length-1;
        int left = 0;
        int right = n-1;
        while (left <= right && nums[left] == numsCopy[left]) {
            left++;
        }
        while (left <=right && nums[right] == numsCopy[right]) {
            right--;
        }
        return right - left +1;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray solution = new FindUnsortedSubarray();
        System.out.println(solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(solution.findUnsortedSubarray(new int[]{1, 2, 3, 4}));
    }
}
