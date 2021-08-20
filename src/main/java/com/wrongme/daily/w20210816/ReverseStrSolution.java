package com.wrongme.daily.w20210816;

public class ReverseStrSolution {

    public String reverseStr(String s, int k) {
        int remain = s.length();
        char[] chars = s.toCharArray();
        if (remain < k) {
            return revert(s);
        }
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            int start = i * k + k;
            int end = (i + 1) * k + k;
            if (n-start ==0){
                break;
            }
            if (n - start < k) {
                return s.substring(0,start)+revert(s.substring(start));
            }
            if (end >n){
                end = n;
            }
            s =s.substring(0,start)+revert(s.substring(start,end))+s.substring(end);
        }
        return s;
    }

    private String revert(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        for (int i = 0, j = n - 1; i < j; i++) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseStrSolution strSolution = new ReverseStrSolution();
        System.out.println(strSolution.reverseStr("abcdefg", 2));
        System.out.println(strSolution.reverseStr("bacd", 2));
    }
}
