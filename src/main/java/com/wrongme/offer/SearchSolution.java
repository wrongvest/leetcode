package com.wrongme.offer;

/***
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class SearchSolution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int ans = 0;
        while (right >= 0 && nums[right] == target) {
            right--;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchSolution solution = new SearchSolution();
        System.out.println(solution.search(new int[]{5, 7, 7,8, 8, 8,8, 10}, 8));
    }
}
