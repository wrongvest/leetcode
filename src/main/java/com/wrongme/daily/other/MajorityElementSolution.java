package com.wrongme.daily.other;

/**
 * 面试题 17.10. 主要元素
 */
public class MajorityElementSolution {
    public int majorityElement(int[] nums) {
        int importantEle = -1;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                cnt = 1;
                importantEle = num;
            } else {
                if (importantEle == num) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        if (cnt == 0) {
            return -1;
        }
        int count = 0;
        for (int num : nums) {
            if (importantEle == num) {
                count++;
            }
        }
        return (nums.length / 2) >= count ? -1 : importantEle;
    }

    public static void main(String[] args) {
        MajorityElementSolution solution = new MajorityElementSolution();
//        System.out.println(solution.majorityElement(new int[]{1,2,5,9,5,9,5,5,5}));
//        System.out.println(solution.majorityElement(new int[]{3,2}));
//        System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(solution.majorityElement(new int[]{1,2,3}));
    }
}
