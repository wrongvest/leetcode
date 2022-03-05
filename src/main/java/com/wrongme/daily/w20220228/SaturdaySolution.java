package com.wrongme.daily.w20220228;

public class SaturdaySolution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
