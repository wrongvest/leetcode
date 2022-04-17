package com.wrongme.topic_backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 */
public class BackTracking_17 {

    Map<String, String[]> map = new HashMap<String, String[]>() {{
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, sb, ans);
        return ans;
    }

    private void dfs(String digits, int i, StringBuilder sb, List<String> ans) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String key = digits.charAt(i) + "";
        String[] strs = map.get(key);
        for (String str : strs) {
            sb.append(str);
            dfs(digits, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        BackTracking_17 backTracking_17 = new BackTracking_17();
//        backTracking_17.letterCombinations("23").forEach(System.out::println);
        backTracking_17.letterCombinations("2").forEach(System.out::println);
    }


}
