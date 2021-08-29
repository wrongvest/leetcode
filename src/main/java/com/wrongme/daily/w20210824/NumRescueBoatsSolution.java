package com.wrongme.daily.w20210824;

import java.util.Arrays;

/**
 * 881. 救生艇
 */
public class NumRescueBoatsSolution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        // 双指针
        int left = 0, right = people.length-1;
        int ans = 0;
        while (left <= right) {
            if (people[right]>=limit || people[left]+people[right] >limit){
                ans ++;
                right--;
            }else if (people[left]+people[right] <=limit){
                ans ++;
                left++;
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumRescueBoatsSolution solution = new NumRescueBoatsSolution();
        System.out.println(solution.numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(solution.numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println(solution.numRescueBoats(new int[]{3,5,3,4}, 5));
    }
}

