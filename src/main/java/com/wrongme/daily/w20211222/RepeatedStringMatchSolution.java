package com.wrongme.daily.w20211222;

/**
 * 686. 重复叠加字符串匹配
 */
public class RepeatedStringMatchSolution {
    public int repeatedStringMatch(String a, String b) {
        boolean[] arr = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < b.length(); i++) {
            if (!arr[b.charAt(i) - 'a']) {
                return -1;
            }
        }
        int count = b.length() / a.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(a);
        }
        for (int i = 0; i <= 2; i++) {
            if (sb.indexOf(b) >= 0) {
                return count + i;
            }
            sb.append(a);
        }
        return -1;
    }

    public static void main(String[] args) {
        RepeatedStringMatchSolution solution = new RepeatedStringMatchSolution();
//        System.out.println(solution.repeatedStringMatch("a", "a"));
//        System.out.println(solution.repeatedStringMatch("a", "aa"));
//        System.out.println(solution.repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(solution.repeatedStringMatch("abc", "cabcabca"));
    }
}
