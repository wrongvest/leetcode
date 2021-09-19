package com.wrongme.daily.w20210907;

public class FindPeakElementSolution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
//        int n = nums.length;
//        int l = 0, r = n - 1;
//        while (l < r) {
//            int mid = l + r >> 1;
//            if (nums[mid] > nums[mid + 1]) r = mid;
//            else l = mid + 1;
//        }
//        return r;

    }

    public static void main(String[] args) {
        FindPeakElementSolution solution = new FindPeakElementSolution();
        System.out.println(solution.findPeakElement(new int[]{1, 2, 3, 1}));
    }
}
