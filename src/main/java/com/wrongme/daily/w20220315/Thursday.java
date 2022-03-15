package com.wrongme.daily.w20220315;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 */
public class Thursday {

    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        int n = nums.length;
        // 所有元素做或运算的结果肯定是最大值
        for (int num : nums) {
            max |= num;
        }
        int ans = 0;
        // 1 << n  在n个数中总共选择的组合
        // 比如说 0 个元素 只能不选 2^0 = 1
        //        1 个元素 可以选也可以不选 2^1 = 2
        //        2 个元素 选第一个或者第二个 ，两个都选或者两个都不选 2^2 = 4
        //        3 个元素 依次类推 2^3 = 8
        // mask 就是这个状态位的集合，比如说 101 选 第0 和 第2位
        for (int mask = 0; mask < (1 << n); mask++) {
            int or = 0;
            for (int i = 0; i < n; i++) {
                // 要不要选第i个数呢？
                // 只需要看最后一位是0不选，最后一位1 选
                if ((mask >> i & 1) == 0) {
                    or |= nums[i];
                }
            }
            if (max==or){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Thursday thursday = new Thursday();
        System.out.println(thursday.countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(thursday.countMaxOrSubsets(new int[]{2, 2,2}));
    }
}
