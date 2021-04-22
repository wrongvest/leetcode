package com.wrongme.offer;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyPowTest {

    @Test
    public void myPow() {
        MyPow pow = new MyPow();
        pow.myPow(2.0,10);
        pow.myPow(2.0,18);
    }
}