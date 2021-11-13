package com.wrongme.weekly.w262;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoOutOfThreeSolution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set= new HashSet<>();
        set.addAll(find(nums1,nums2));
        set.addAll(find(nums2,nums3));
        set.addAll(find(nums1,nums3));
        return new ArrayList<>(set);
    }
    private Set<Integer> find(int[] nums1,int[] nums2){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <nums1.length ; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i]==nums2[j]){
                    set.add(nums1[i]);
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        TwoOutOfThreeSolution solution = new TwoOutOfThreeSolution();
        int[] nums1=new int[]{1,1,3,2} ;
        int[] nums2 = new int[]{2,3};
        int[] nums3 = new int[]{3};
        solution.twoOutOfThree(nums1,nums2,nums3).forEach(System.out::println);
    }
}
