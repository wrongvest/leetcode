package com.wrongme.daily.w20220228;

import java.util.HashSet;
import java.util.Set;

/**
 * 564. 寻找最近的回文数
 */
public class WednesdaySolution {

    public String nearestPalindromic(String s) {
        int n = s.length();
        long cur = Long.parseLong(s);
        Set<Long> set = new HashSet<>();
        set.add((long) (Math.pow(10, n - 1) - 1));
        set.add((long) (Math.pow(10, n) + 1));
        long t = Long.parseLong(s.substring(0, (n + 1) / 2));
        for (long i = (t - 1); i <= t + 1; i++) {
            long temp = getNum(i, n % 2 == 0);
            if (temp != cur) {
                set.add(temp);
            }
        }
        long ans = -1;
        for (Long i : set) {
            if (ans == -1) {
                ans = i;
            } else if (Math.abs(i - cur) < Math.abs(ans - cur)) {
                ans = i;
            } else if (Math.abs(i - cur) == Math.abs(ans - cur) && i < ans) {
                ans = i;
            }

        }
        return ans + "";
    }

    /**
     * 例如 输入为 123 长度为奇数截取 12 ；
     * 再如 输入为 4563 长度为偶数数截取 45 ；
     *
     * @param k      截取的前半段
     * @param isEven 是否偶数
     * @return
     */
    private long getNum(long k, boolean isEven) {
        StringBuilder sb = new StringBuilder(k + "");
        int length = sb.length();
        // appendLength +1: 还需要填充的位数
        // 为奇数时需要填充 n-2个数字
        int appendLength = isEven ? length - 1 : length - 2;
        while (appendLength >= 0) {
            sb.append(sb.charAt(appendLength--));
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        WednesdaySolution solution = new WednesdaySolution();
        System.out.println(solution.nearestPalindromic("123"));
        System.out.println(solution.nearestPalindromic("1"));
        System.out.println(solution.nearestPalindromic("9677"));
        System.out.println(solution.nearestPalindromic("11011"));
    }
}
