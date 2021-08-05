package com.wrongme.sort;

/**
 * 插入排序
 * 思路：每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组，有限次操作以后，数组整体有序。
 */
public class InsertSort {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            // 先暂存这个元素
            int temp = nums[i];
            int j =i;
            while (j>0 && nums[j-1]>temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        insertSort.sortArray(new int[]{2,22,5,8,7,3,1,2,4});
    }
}
