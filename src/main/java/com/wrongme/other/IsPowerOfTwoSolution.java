package com.wrongme.other;

public class IsPowerOfTwoSolution {
    public boolean isPowerOfTwo(int n) {
        if (n >= 0 ) {
            return Integer.bitCount(n) == 1;
        }
        return false;
    }
}
