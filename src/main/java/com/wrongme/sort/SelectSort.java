package com.wrongme.sort;

import java.util.Arrays;

/**
 * 选择排序
 * https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/
 */
public class SelectSort {
    /**
     * 思路：每一轮选取未排定的部分中最小的部分交换到未排定部分的最开头，经过若干个步骤，就能排定整个数组。
     * 即：先选出最小的，再选出第 2 小的，以此类推。
     *
     * 算法思想 1：贪心算法：每一次决策只看当前，当前最优，则全局最优。注意：这种思想不是任何时候都适用。
     *
     * 算法思想 2：减治思想：外层循环每一次都能排定一个元素，问题的规模逐渐减少，直到全部解决，即「大而化小，小而化了」。
     * 运用「减治思想」很典型的算法就是大名鼎鼎的「二分查找」。
     *
     * 优点：交换次数最少。
     *
     */
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums,i,minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int minIndex) {
        int temp = nums[minIndex];
        nums[minIndex] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        System.out.println(Arrays.toString(selectSort.sortArray(new int[]{6, 3, 24, 1, 2, 7, 10, 8, 2, 2, 3})));
    }
}
