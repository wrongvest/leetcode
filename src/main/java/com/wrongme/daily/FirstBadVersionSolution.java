package com.wrongme.daily;

/**
 * 278. 第一个错误的版本
 */
public class FirstBadVersionSolution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            long temp = (long) l + r >> 1;
            int mid = (int) temp;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        FirstBadVersionSolution solution = new FirstBadVersionSolution();
        solution.firstBadVersion(5);
    }
}


class VersionControl {
    static boolean[] vesrions = new boolean[]{false, false, false, false, true, true, true, true, true, true, true, true};

    boolean isBadVersion(int version) {
        return vesrions[version];
    }
}