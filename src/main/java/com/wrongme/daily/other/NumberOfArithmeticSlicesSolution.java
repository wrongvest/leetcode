package com.wrongme.daily.other;

import java.util.ArrayList;
import java.util.List;

public class NumberOfArithmeticSlicesSolution {

    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        int[] diffs = new int[length-1];
        for (int i = 1,j=0; i < nums.length; i++,j++) {
            diffs[j] = nums[i]-nums[i-1];
        }
        if (diffs.length<2){
            return 0;
        }
        List<Integer> cons = new ArrayList<>();
        int con = 1;
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i]==diffs[i-1]){
                con ++;
            }else {
                cons.add(con);
                con = 1;
            }
        }
        cons.add(con);
        int ans =0;
        for (int n : cons) {
            if (n==1){
                continue;
            }
            n+=1;
           ans +=  (n-2)*(n-1)/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfArithmeticSlicesSolution solution = new NumberOfArithmeticSlicesSolution();
       // System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6, 12, 14, 16}));
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
}
