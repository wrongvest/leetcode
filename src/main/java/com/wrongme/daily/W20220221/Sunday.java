package com.wrongme.daily.W20220221;

public class Sunday {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i+1<nums.length) {
                sb.append("/");
            }
        }
        if (nums.length>2){
            sb.insert(sb.indexOf("/")+1,"(");
            sb.append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Sunday sunday = new Sunday();
        System.out.println(sunday.optimalDivision(new int[]{1000, 100, 10, 2}));
        System.out.println(sunday.optimalDivision(new int[]{1000, 100}));
    }
}
