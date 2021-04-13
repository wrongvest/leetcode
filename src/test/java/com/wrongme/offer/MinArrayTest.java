package com.wrongme.offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinArrayTest {

    @Test
    public void minArray() {
        int[] temp = new int[]{1,2,3};
        MinArray minArray = new MinArray();
        assertEquals(1,minArray.minArray(temp));
    }
}