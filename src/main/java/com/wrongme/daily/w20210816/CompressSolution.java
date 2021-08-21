package com.wrongme.daily.w20210816;

import java.util.Stack;

/**
 * 443. 压缩字符串
 */
public class CompressSolution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n <= 1) {
            return 1;
        }
        Stack<Character> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                char pop = stack.peek();
                if (pop == chars[i]) {
                    stack.push(chars[i]);
                } else {
                    j = getJ(chars, stack, j);
                    stack.push(chars[i]);
                }
            }
        }
        j = getJ(chars, stack, j);
        return j;
    }

    private int getJ(char[] chars, Stack<Character> stack, int j) {
        char c = stack.pop();
        int k = 1;
        while (!stack.isEmpty()) {
            stack.pop();
            k++;
        }
        chars[j] = c;
        j = j + 1;
        if (k == 1) {
            // do nothing
        } else if (k >= 10) {
            String temp = (k + "");
            for (int l = 0; l < temp.length(); l++) {
                chars[j+l] = temp.charAt(l);
            }
            j = j + temp.length();

        } else {
            chars[j] = (k +"").charAt(0);
            j = j + 1;
        }
        return j;
    }

    public static void main(String[] args) {
        CompressSolution solution = new CompressSolution();
        System.out.println(solution.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(solution.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b','b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(solution.compress(new char[]{'a'}));
    }

}
