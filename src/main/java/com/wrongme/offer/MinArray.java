package com.wrongme.offer;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class MinArray {
    public int minArray(int[] numbers) {
        // 二分查找
        // 大 【最小】 小
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid]<numbers[high]){
                high = mid;
            }else if (numbers[mid]>numbers[high]){
                low = mid+1;
            }else {
                high -=1;
            }
        }
        return numbers[low ];
    }
}
