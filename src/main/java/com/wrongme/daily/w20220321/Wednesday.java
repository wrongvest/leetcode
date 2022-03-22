package com.wrongme.daily.w20220321;

public class Wednesday {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int a = 0;
        int b = 0;
        for (int i = 1; i < n - 1; i++) {
            if (colors.charAt(i) == 'A' && colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') {
                a++;
            }
            if (colors.charAt(i) == 'B' && colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') {
                b++;
            }
        }
        return a > b;
    }

    public static void main(String[] args) {
        Wednesday w = new Wednesday();
        System.out.println(w.winnerOfGame("AAABABB"));
        System.out.println(w.winnerOfGame("AA"));
        System.out.println(w.winnerOfGame("ABBBBBBBAAA"));
        System.out.println(w.winnerOfGame("AAABBBA"));
    }
}
