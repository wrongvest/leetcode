package com.wrongme.other;

import org.junit.Test;

public class TotalHammingDistanceSolutionTest {

    @Test
    public void totalHammingDistance() {
        TotalHammingDistanceSolution solution = new TotalHammingDistanceSolution();
        int[] nums = new int[]{4,14,2};
        System.out.println(solution.totalHammingDistance(nums));
    }
}