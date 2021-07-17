package com.wrongme.daily;

import java.util.Arrays;

/**
 * 1846. 减小和重新排列数组后的最大元素
 */
public class MaximumElementAfterDecrementingAndRearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i-1]+1;
            }
        }
        return arr[arr.length-1];
    }


    public static void main(String[] args) {
        MaximumElementAfterDecrementingAndRearranging solution = new MaximumElementAfterDecrementingAndRearranging();
        System.out.println(solution.maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));
        System.out.println(solution.maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000}));
        System.out.println(solution.maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}));
    }

}
