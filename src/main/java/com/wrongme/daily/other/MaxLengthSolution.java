package com.wrongme.daily.other;

import java.util.ArrayList;
import java.util.List;

public class MaxLengthSolution {
    int ans = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        // 先去除包含重复元素的子串
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - 'a';
                // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                if (((mask >> ch) & 1) != 0) {
                    mask = 0;
                    break;
                }
                // 将 ch 加入 mask 中
                mask = mask | 1 << ch;
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }
        // 回溯
        backtrack(masks, 0, 0);
        return ans;
    }

    private void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        // mask 和 masks[pos] 无公共元素,则可以选当前串
        if ((mask & masks.get(pos)) == 0) {
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        // 不选当前串，mask值不变
        backtrack(masks, pos + 1, mask);
    }

    public static void main(String[] args) {
        MaxLengthSolution solution = new MaxLengthSolution();
        List<String> list = new ArrayList<>();
        list.add("abcdefg");
        list.add("un");
        list.add("iq");
        list.add("ue");
        solution.maxLength(list);
    }
}
