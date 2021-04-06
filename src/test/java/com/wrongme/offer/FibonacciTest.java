package com.wrongme.offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void fib1() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(0, fibonacci.fib1(0));
        assertEquals(1, fibonacci.fib1(1));
        assertEquals(1, fibonacci.fib1(2));
        assertEquals(2, fibonacci.fib1(3));
        assertEquals(3, fibonacci.fib1(4));
        assertEquals(5, fibonacci.fib1(5));
        assertEquals(8, fibonacci.fib1(6));

    }
}