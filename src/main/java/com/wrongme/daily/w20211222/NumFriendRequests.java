package com.wrongme.daily.w20211222;

import java.util.Arrays;

public class NumFriendRequests {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        int n = ages.length;
        for (int i = 0, j = 0, k = 0; k < n; k++) {
            while (i < k && !cheack(ages[i], ages[k])) {
                i++;
            }
            if (j < k) {
                j = k;
            }
            while (j < n && cheack(ages[j], ages[k])) {
                j++;
            }
            if (j > i) {
                ans += j - i - 1;
            }
        }
        return ans;
    }

    boolean cheack(int x, int y) {
        if (y <= 0.5 * x + 7) {
            return false;
        }
        if (y > x) {
            return false;
        }
        if (y > 100 && x < 100) {
            return false;
        }
        return true;
    }
}
