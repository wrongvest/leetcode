package com.wrongme.daily.w20210816;

public class ReverseVowelsSolution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = 0,j=n-1;
        for (; i<=j; ) {
            if (checkVowels(chars[i])&&checkVowels(chars[j])){
                char tem = chars[i];
                chars[i] = chars[j];
                chars[j] = tem;
                i++;
                j--;
                continue;
            }
            if (!checkVowels(chars[i])){
                i++;
            }
            if (!checkVowels(chars[j])){
                j--;
            }
        }
        return new String(chars);
    }

    private boolean checkVowels(char aChar) {
        return aChar == 'a' || aChar == 'e' || aChar == 'i' || aChar == 'o' || aChar == 'u'||
                aChar == 'A' || aChar == 'E' || aChar == 'I' || aChar == 'O' || aChar == 'U';
    }

    public static void main(String[] args) {
        ReverseVowelsSolution solution = new ReverseVowelsSolution();
        System.out.println(solution.reverseVowels("hello"));
        System.out.println(solution.reverseVowels("leetcode"));
    }
}
