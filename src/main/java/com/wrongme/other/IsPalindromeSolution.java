package com.wrongme.other;

public class IsPalindromeSolution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] chars = Integer.toString(x).toCharArray();
        char[] temp = new char[chars.length];
        for (int i = chars.length - 1,j=0; i >= 0; i--,j++) {
            temp[j] = chars[i];
        }
        int reverse =  Integer.valueOf(String.valueOf(temp));
        return reverse == x;
    }
}
