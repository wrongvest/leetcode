package com.wrongme.daily.w20211001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 */
public class FindRepeatedDnaSequencesSolution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= n; i++) {
            String cur = s.substring(i,i+10);
            int cnt = map.getOrDefault(cur,0);
            if (cnt==1){
                ans.add(cur);
            }
            map.put(cur,cnt+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindRepeatedDnaSequencesSolution sequencesSolution  = new FindRepeatedDnaSequencesSolution();
        sequencesSolution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").forEach(System.out::println);
        sequencesSolution.findRepeatedDnaSequences("AAAAAAAAAAAAA").forEach(System.out::println);
    }
}
