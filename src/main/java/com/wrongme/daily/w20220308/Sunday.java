package com.wrongme.daily.w20220308;

public class Sunday {
    public boolean validUtf8(int[] data) {
        //用于判断data首字节后一共有几个字节
        int bitIndex = 0;
        for (int num : data) {
            if (bitIndex == 0) {
                if (num >> 5 == 0b110) {
                    bitIndex = 1;
                } else if (num >> 4 == 0b1110) {
                    bitIndex = 2;
                } else if (num >> 3 == 0b11110) {
                    bitIndex = 3;
                } else if (num >> 7 != 0) {
                    return false;
                }
            } else {
                if (num >> 6 != 0b10) {
                    return false;
                }
                --bitIndex;
            }
        }
        return bitIndex == 0;
    }

    public static void main(String[] args) {
        Sunday sunday = new Sunday();
        System.out.println(sunday.validUtf8(new int[]{197, 130, 1}));
        System.out.println(sunday.validUtf8(new int[]{235, 140, 4}));
//        System.out.println(Integer.toBinaryString(197));
//        System.out.println(Integer.toBinaryString(130));
//        System.out.println(Integer.toBinaryString(1));

//        System.out.println(Integer.toBinaryString(235));
//        System.out.println(Integer.toBinaryString(140));
//        System.out.println(Integer.toBinaryString(4));
    }

}
