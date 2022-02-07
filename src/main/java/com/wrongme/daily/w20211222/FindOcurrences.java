package com.wrongme.daily.w20211222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOcurrences {
    public String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (i + 1 < s.length &&i + 2 < s.length && first.equals(s[i]) && second.equals(s[i + 1])) {
                temp.add(s[i + 2]);
            }
        }
        String[] ans = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindOcurrences f = new FindOcurrences();
        Arrays.stream(f.findOcurrences("alice is a good girl she is a good student", "a", "good")).forEach(System.out::println);
        Arrays.stream(f.findOcurrences("we will we will rock you", "we", "will")).forEach(System.out::println);
        Arrays.stream(f.findOcurrences("jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa", "kcyxdfnoa", "jkypmsxd")).forEach(System.out::println);
    }

}
