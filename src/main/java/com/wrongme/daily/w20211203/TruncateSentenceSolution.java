package com.wrongme.daily.w20211203;

public class TruncateSentenceSolution {
    public String truncateSentence(String s, int k) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (i<k-1) {
                sb.append(strs[i] + " ");
            }else {
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TruncateSentenceSolution solution = new TruncateSentenceSolution();
        System.out.println(solution.truncateSentence("Hello how are you", 2));
    }
}
