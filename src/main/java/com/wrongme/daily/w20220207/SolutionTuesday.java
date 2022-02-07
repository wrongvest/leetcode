package com.wrongme.daily.w20220207;

import java.util.Arrays;

/**
 * 1405. 最长快乐字符串
 */
public class SolutionTuesday {
    // 优先使用数量最多的字符 来拼凑字符串，当数量最多的与已拼凑的字符串后两位相同时，我们应该
    // 使用数量次多的字符 来拼凑字符串，依次往复，最终可以得到我们的结果。
    public String longestDiverseString(int a, int b, int c) {
        int[][] arr = new int[][]{{'a', a}, {'b', b}, {'c', c}};
        StringBuilder sb = new StringBuilder(a + b + c);
        while (true) {
            Arrays.sort(arr, (x, y) -> y[1] - x[1]);
            int n = sb.length();
            // 如果数量最多的为0了，跳出循环
            if (arr[0][1] == 0) {
                break;
            }
            if (n >= 2 && sb.charAt(n - 1) == arr[0][0] && sb.charAt(n - 2) == arr[0][0]) {
                if (arr[1][1] == 0) {
                    break;
                }
                sb.append((char) arr[1][0]);
                arr[1][1]--;
            } else {
                // 拼接数量最多的，同时其数量减1
                sb.append((char) arr[0][0]);
                arr[0][1]--;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SolutionTuesday tuesday = new SolutionTuesday();
        System.out.println(tuesday.longestDiverseString(1, 1, 7));
    }
}
