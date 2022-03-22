package com.wrongme.topic_slide_window;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 */
public class SlideWindow_3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char right = s.charAt(j);
            map.put(right, map.getOrDefault(right, 0) + 1);
            while (map.get(right) > 1) {
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        SlideWindow_3 slideWindow_3 = new SlideWindow_3();
        System.out.println(slideWindow_3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(slideWindow_3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(slideWindow_3.lengthOfLongestSubstring("pwwkew"));
    }
}
