package com.wrongme.topic_slide_window;

public class SlideWindows_643 {
    public double findMaxAverage(int[] nums, int k) {
        double mem = 0;
        // 初始化：将滑动窗口压满
        for (int i = 0; i < k; i++) {
            mem = mem + nums[i];
        }
        double maxAvg = mem / k;
        for (int i = 1, j = k; i < nums.length && j< nums.length; i++, j++) {
            double sum = mem - nums[i - 1] + nums[j];
            double avg = sum / k;
            mem = sum;
            maxAvg = Math.max(avg, maxAvg);
            if (j == nums.length - 1) {
                break;
            }
        }
        return maxAvg;
    }

    /**
     * 暴力解
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage2(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int temp = 0;
            double sum = 0;
            while (temp < k && j < nums.length) {
                sum = sum + nums[j];
                j++;
                temp++;
            }
            double avg = sum / k;
            maxAvg = Math.max(avg, maxAvg);
            if (j == nums.length - 1) {
                break;
            }
        }
        return maxAvg;
    }

    public double findMaxAverage3(int[] nums, int k) {
        double sum = 0;
        // 初始化：将滑动窗口压满
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        double maxAvg = sum / k;
        for (int i = 1, j = k; j< nums.length; i++, j++) {
            // 继续滑动窗口，每往前滑动一次，需要删除一个和添加一个元素
            sum = sum - nums[i - 1] + nums[j];
            maxAvg = Math.max(sum / k, maxAvg);
        }
        return maxAvg;
    }



    public static void main(String[] args) {
        SlideWindows_643 slideWindows_643 = new SlideWindows_643();
        System.out.println(slideWindows_643.findMaxAverage3(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(slideWindows_643.findMaxAverage3(new int[]{4,0,4,3,3}, 5));
        System.out.println(slideWindows_643.findMaxAverage3(new int[]{4,2,1,3,3}, 2));
        System.out.println(slideWindows_643.findMaxAverage3(new int[]{5}, 1));
    }
}
