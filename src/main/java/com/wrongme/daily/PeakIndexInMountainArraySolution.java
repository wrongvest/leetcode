package com.wrongme.daily;

public class PeakIndexInMountainArraySolution {
    // error
    public int peakIndexInMountainArray1(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) >> 1;
//            if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
//                return mid;
//            }
            if (arr[mid - 1] == arr[mid + 1]) {
                return mid;
            }
            if (arr[mid - 1] < arr[mid] && arr[mid + 1] > arr[mid]) {
                // 答案在区间 [left, mid] 中
                left = mid;
            } else {
                // 答案在区间 [mid+1, right] 中
                right = mid;
            }
        }
        return left;
    }

    public static int peakIndexInMountainArray2(int[] arr) {
        int left = 1, right = arr.length - 1;
        while (left < right) {
//            int mid = left + (right - left) >> 1;
            int mid = left + right + left >> 1;
            if (arr[mid - 1] < arr[mid]) {
                left = mid;
            }else {
                right =mid-1;
            }
        }
        return left;
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 1;
        while (left < right) {
            // 将当前区间分为 [l, m1][、[m1, m2] 和 [m2, r][m2,r] 三段
            // 如果满足 arr[m1] > arr[m2]，说明峰顶元素不可能存在与 [m2, r][m2,r] 中，让 r = m2 - 1r=m2−1 即可
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1, 0};
        System.out.println(peakIndexInMountainArray(arr1));
        int[] arr2 = new int[]{0, 2, 1, 0};
        System.out.println(peakIndexInMountainArray(arr2));
    }
}
