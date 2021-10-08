package com.wrongme.daily.w20211001;

import java.util.*;

public class ThirdMaxSolution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        if (list.size()<=2){
            return list.get(list.size()-1);
        }
        return list.get(list.size()-3);
    }

    public static void main(String[] args) {
        ThirdMaxSolution solution = new ThirdMaxSolution();
//        System.out.println(solution.thirdMax(new int[]{3, 2, 1}));
//        System.out.println(solution.thirdMax(new int[]{1, 2}));
//        System.out.println(solution.thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(solution.thirdMax(new int[]{-2147483648,1,1}));
    }
}
