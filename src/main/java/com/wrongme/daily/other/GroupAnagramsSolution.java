package com.wrongme.daily.other;

import java.util.*;

/**
 * 面试题 10.02. 变位词组
 */
public class GroupAnagramsSolution {

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            List<String> list = map.getOrDefault(new String(chars), new ArrayList<>());
            list.add(strs[i]);
            map.put(new String(chars),list);
        }
        List<List<String>> ans = new ArrayList<>();
        map.forEach((k,v)-> ans.add(v));
        return ans;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] cnts = new int[26];
            for (char c : s.toCharArray()) cnts[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i : cnts) sb.append(i + "_");
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        for (String key : map.keySet()) ans.add(map.get(key));
        return ans;

    }

    public static void main(String[] args) {
        GroupAnagramsSolution solution = new GroupAnagramsSolution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }
}
