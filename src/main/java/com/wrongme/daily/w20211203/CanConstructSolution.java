package com.wrongme.daily.w20211203;

public class CanConstructSolution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chs1 = new int[26];
        int[] chs2 = new int[26];
        for (int i = 0; i < ransomNote.length() || i < magazine.length(); i++) {
            if (i < ransomNote.length()) {
                int c = ransomNote.charAt(i) - 'a';
                chs1[c] = chs1[c]+1;
            }
            if (i < magazine.length()) {
                int c = magazine.charAt(i) - 'a';
                chs2[c] = chs2[c]+1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (chs1[i]>chs2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanConstructSolution solution = new CanConstructSolution();
        System.out.println(solution.canConstruct("aa", "ab"));
        System.out.println(solution.canConstruct("aa", "aab"));
        System.out.println(solution.canConstruct("aabbb", "abab"));
    }
}
