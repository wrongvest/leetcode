package com.wrongme.offer;

public class IntToRomanSolution {

    int intNums[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String romaNums[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        String str = "";
        for (int i = 0; i < intNums.length; i++) {
            int value = intNums[i];
            while (value<=num){
                num = num -value;
                str= str+romaNums[i];
            }
            if (num==0){
                break;
            }
        }
        return str;
    }
}
