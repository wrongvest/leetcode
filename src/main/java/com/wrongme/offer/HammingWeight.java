package com.wrongme.offer;

public class HammingWeight {
    public int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count=0;
        for (char c : binaryString.toCharArray()) {
            if (c=='1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(102));
    }
}
