package com.wrongme.daily.w20210831;

public class CompareVersionSolution {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; i++) {
            if (i < v1.length && i < v2.length) {
                if (Integer.valueOf(v1[i]).equals(Integer.valueOf(v2[i]))) {
                    continue;
                } else if (Integer.valueOf(v1[i]) - (Integer.valueOf(v2[i])) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }

            if (i < v1.length) {
                if (Integer.valueOf(v1[i]).equals(0)) {
                    continue;
                } else {
                    return 1;
                }
            }

            if (Integer.valueOf(v2[i]).equals(0)) {
            } else {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionSolution solution = new CompareVersionSolution();
        System.out.println(solution.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(solution.compareVersion("1.0.1", "1"));
        System.out.println(solution.compareVersion("0.1", "1.1"));
        System.out.println(solution.compareVersion("1.01", "1.001"));
        System.out.println(solution.compareVersion("1.0", "1.0.0"));
        System.out.println(solution.compareVersion("1", "1.1"));
    }
}
