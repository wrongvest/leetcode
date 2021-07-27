package com.wrongme.weekly.w251;

/**
 * 5824. 子字符串突变后可能得到的最大整数
 */
public class MaximumNumberSolution {

    public String maximumNumber(String num, int[] change) {
        boolean[] flag = new boolean[num.length()];
        StringBuilder sb = new StringBuilder(num);
        int j = 0;//变化次数
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int v = c - '0';
            if (change[v] >= v) {
                if (j > 0) {
                    if (!flag[i - 1]) {
                        if (!num.equals(sb.toString())) {
                            break;
                        }
                        flag = new boolean[num.length()];
                        j = 0;
                    }
                }
                sb.replace(i, i + 1, change[v] + "");
                flag[i] = true;
                j++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MaximumNumberSolution solution = new MaximumNumberSolution();
        System.out.println(solution.maximumNumber("132", new int[]{9, 8, 5, 0, 3, 6, 4, 2, 6, 8}));
        System.out.println(solution.maximumNumber("021", new int[]{9, 4, 3, 5, 7, 2, 1, 9, 0, 6}));
        System.out.println(solution.maximumNumber("214010", new int[]{6,7,9,7,4,0,3,4,4,7}));
        System.out.println(solution.maximumNumber("334111", new int[]{0, 9, 2, 3, 3, 2, 5, 5, 5, 5}));
    }
}
