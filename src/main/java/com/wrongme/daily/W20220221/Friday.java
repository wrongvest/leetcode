package com.wrongme.daily.W20220221;

public class Friday {
    public String complexNumberMultiply(String num1, String num2) {
        String[] num1Spilt = num1.split("\\+");
        num1Spilt[1]= num1Spilt[1].replace("i","");
        String[] num2Spilt = num2.split("\\+");
        num2Spilt[1]= num2Spilt[1].replace("i","");
        int m1 = Integer.valueOf(num1Spilt[0]) * Integer.valueOf(num2Spilt[0]);
        int a1 = Integer.valueOf(num1Spilt[0]) * Integer.valueOf(num2Spilt[1]);
        // 虚数
        int a2 = Integer.valueOf(num1Spilt[1]) * Integer.valueOf(num2Spilt[0]);
        // 实数
        int m2 = Integer.valueOf(num1Spilt[1]) * Integer.valueOf(num2Spilt[1]);
        int m = m1 - m2;
        int n = a1 + a2;
        return m + "+" + n + "i";
    }


    public static void main(String[] args) {
        Friday friday = new Friday();
        System.out.println(friday.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(friday.complexNumberMultiply("1+-1i", "1+-1i"));
        System.out.println(friday.complexNumberMultiply("1+-1i", "0+0i"));
    }
}
