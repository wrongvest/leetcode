package com.wrongme.other;

import org.junit.Test;

public class TopKFrequentSolutionTest {

    @Test
    public void topKFrequent() {
        TopKFrequentSolution solution = new TopKFrequentSolution();
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        solution.topKFrequent(words,2);
    }
}