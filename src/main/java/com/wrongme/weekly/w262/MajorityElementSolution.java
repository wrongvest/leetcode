package com.wrongme.weekly.w262;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementSolution {
    Map<Integer,Integer> map = new HashMap<>();
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        int m = n/3;
        map.forEach((k,v)->{
            if (v>m){
                ans.add(k);
            }
        });
        return ans;
    }

    public static void main(String[] args) {
        MajorityElementSolution solution = new MajorityElementSolution();
//        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution.majorityElement(new int[]{1,1,1,3,3,2,2,2}));
    }
}
