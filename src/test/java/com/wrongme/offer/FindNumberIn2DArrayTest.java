package com.wrongme.offer;

import org.junit.Before;
import org.junit.Test;

public class FindNumberIn2DArrayTest {
    int[][] temp = new int[3][4];

    @Before
    public void init() {
        temp[0] = new int[]{1, 4, 7, 10};
        temp[1] = new int[]{2, 5, 8, 11};
        temp[2] = new int[]{3, 6, 9, 12};
    }

    @Test
    public void findNumberIn2DArray() {
        FindNumberIn2DArray dArray = new FindNumberIn2DArray();
        System.out.println(dArray.findNumberIn2DArray(temp,10));
        // 有多少行
        System.out.println(temp.length);
        // 一行有多少个元素
        System.out.println(temp[0].length);
    }
}