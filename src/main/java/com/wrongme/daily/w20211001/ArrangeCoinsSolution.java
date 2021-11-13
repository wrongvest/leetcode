package com.wrongme.daily.w20211001;

public class ArrangeCoinsSolution {
    public int arrangeCoins(int n) {
        int i=1,sum=0;
        while (sum+i<=n){
            sum = sum+i;
            i++;
            if (sum+i>n){
                i--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        ArrangeCoinsSolution solution = new ArrangeCoinsSolution();
        System.out.println(solution.arrangeCoins(5));
        System.out.println(solution.arrangeCoins(8));
    }
}
