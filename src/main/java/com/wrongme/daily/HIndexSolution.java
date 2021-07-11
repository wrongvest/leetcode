package com.wrongme.daily;

/**
 * 274. H 指数
 */
public class HIndexSolution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(citations, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(int[] citations, int mid) {
        int ans =0;
        for (int citation : citations) {
            if (citation>=mid){
                ans++;
            }
        }
        return ans>=mid;
    }
}
