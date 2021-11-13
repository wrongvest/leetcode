package com.wrongme.weekly.w262;

public class DivideSolution {
    int INF = Integer.MAX_VALUE;

    public int divide(int _dividend, int _divisor) {
        long dividend = _dividend, divisor = _divisor;
        boolean flag = false;
        // 是否异号
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            flag = true;
        }
        if (dividend < 0) {
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }
        long left = 0, right = dividend;
        while (left <= right) {
            long mid = left + right + 1 >> 1;
            if (mul(mid, divisor) <= dividend) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        right = flag ? right : -right;
        if (right > INF || right < -INF - 1) return INF;
        return (int) right;
    }

    private long mul(long mid, long divisor) {
        long ans = 0;
        while (divisor> 0) {
            if ((divisor & 1) == 1) ans += mid;
            divisor >>= 1;
            mid += mid;
        }
        return ans;

    }

}
