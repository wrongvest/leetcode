package com.wrongme.daily.w20210831;

public class SearchSolution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchSolution solution = new SearchSolution();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 3));
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 12));
    }
}
