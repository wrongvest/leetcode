package com.wrongme.daily.w20210921;

/**
 * 58. 最后一个单词的长度
 */
public class LengthOfLastWordSolution {

    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        return strs[strs.length-1].length();
    }
}
