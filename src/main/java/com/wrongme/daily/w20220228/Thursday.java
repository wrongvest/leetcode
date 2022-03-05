package com.wrongme.daily.w20220228;

public class Thursday {
    public int addDigits(int num) {
        String ans = String.valueOf(num);
        while (ans.length() > 1) {
            int ansN = 0;
            for (int i = 0; i < ans.length(); i++) {
                ansN =ansN +Integer.parseInt(ans.charAt(i)+"");
            }
            ans = String.valueOf(ansN);
        }
        return Integer.parseInt(ans);
    }

    public static void main(String[] args) {
        Thursday thursday = new Thursday();
        System.out.println(thursday.addDigits(38));
        System.out.println(thursday.addDigits(0));
        System.out.println(thursday.addDigits(10));
        System.out.println(thursday.addDigits(101));
    }
}
