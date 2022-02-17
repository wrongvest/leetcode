package com.wrongme.daily.w20220207;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionSunday {
    public int maxNumberOfBalloons(String text) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            String c = text.charAt(i) + "";
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Integer bSize = map.getOrDefault("b", 0);
        Integer aSize = map.getOrDefault("a", 0);
        Integer llSize = map.get("l") == null ? 0 : (map.get("l") / 2);
        Integer ooSize = map.get("o") == null ? 0 : (map.get("o") / 2);
        Integer nSize = map.getOrDefault("n", 0);
        int[] temp = new int[]{bSize, aSize, llSize, ooSize, nSize};
        Arrays.sort(temp);
        return temp[0];
    }

    public static void main(String[] args) {
        SolutionSunday solutionSunday = new SolutionSunday();
        System.out.println(solutionSunday.maxNumberOfBalloons("nlaebolko"));
        System.out.println(solutionSunday.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(solutionSunday.maxNumberOfBalloons("1"));
    }
}
