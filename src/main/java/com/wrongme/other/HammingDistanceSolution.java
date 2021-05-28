package com.wrongme.other;

public class HammingDistanceSolution {

    public int hammingDistance1(int x, int y) {
        char[] xStr = Integer.toBinaryString(x).toCharArray();
        char[] yStr = Integer.toBinaryString(y).toCharArray();
        int distance = 0;
        if (xStr.length > yStr.length) {
            for (int i = xStr.length - 1, j = yStr.length - 1; i >= 0; i--, j--) {
                if (j >= 0) {
                    if ((xStr[i] ^ yStr[j]) == 1) {
                        distance++;
                    }
                } else {
                    if (xStr[i] == '1') {
                        distance++;
                    }
                }
            }
        } else {
            for (int i = xStr.length - 1, j = yStr.length - 1; j >= 0; i--, j--) {
                if (i >= 0) {
                    if ((xStr[i] ^ yStr[j]) == 1) {
                        distance++;
                    }
                } else {
                    if (yStr[j]== '1') {
                        distance++;
                    }
                }
            }
        }
        return distance;

    }

    public int hammingDistance(int x, int y) {
        int result = x^y;
        int distance = 0;
        while (result!=0){
            distance += result&1;
            result>>=1;
        }
        return distance;
    }

    public static void main(String[] args) {
        HammingDistanceSolution solution = new HammingDistanceSolution();
        System.out.println(solution.hammingDistance(10, 20));
        System.out.println(Integer.toBinaryString(10 ^ 20));
    }
}
