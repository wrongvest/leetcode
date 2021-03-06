package com.wrongme.offer;

/**
 * 剑指 Offer 16. 数值的整数次方
 */
public class MyPow {

    public double myPow(double x, int n) {
        long b = n;
        if(b < 0){
            x = 1 / x;
            b = - b;
        }
        double res = 1;
        while(b != 0){
            if(b % 2 != 0){
                res *= x;
            }
            b >>= 1;
            x *= x;
        }
        return res;
    }


}
