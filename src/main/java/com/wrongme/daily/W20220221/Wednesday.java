package com.wrongme.daily.W20220221;

public class Wednesday {
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (!Character.isLetter(chars[i])) {
                i++;
                continue;
            }
            if (!Character.isLetter(chars[j])) {
                j--;
                continue;
            }
            if (Character.isLetter(chars[i]) && Character.isLetter(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Wednesday wednesday = new Wednesday();
        System.out.println(wednesday.reverseOnlyLetters("ab-cd"));
        System.out.println(wednesday.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(wednesday.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
