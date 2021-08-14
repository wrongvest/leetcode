package com.wrongme.daily;

public class TribonacciSolution {

    public int tribonacci(int n) {
        int[] tab = new int[37];
        tab[0]=0;
        tab[1]=tab[2]=1;
        int i=3;
        while (i<=n){
            tab[i] = tab[i-3]+tab[i-2]+tab[i-1];
            i++;
        }
        return tab[n];
    }

    public static void main(String[] args) {
        TribonacciSolution solution = new TribonacciSolution();
        System.out.println(solution.tribonacci(4));
        System.out.println(solution.tribonacci(25));
    }
}
