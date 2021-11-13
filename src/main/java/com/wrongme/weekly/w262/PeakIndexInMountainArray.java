package com.wrongme.weekly.w262;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (arr[mid] > arr[mid - 1]) {
                left = mid ;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray peak  = new PeakIndexInMountainArray();
        System.out.println(peak.peakIndexInMountainArray(new int[]{1, 3, 5, 4, 2}));
        System.out.println(peak.peakIndexInMountainArray(new int[]{0,2,1,0}));
    }
}
