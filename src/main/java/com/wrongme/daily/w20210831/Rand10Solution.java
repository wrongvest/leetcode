package com.wrongme.daily.w20210831;

public class Rand10Solution {
    public int rand7() {
        return (int) (Math.random() * 10) % 7 + 1;
    }

    public int rand10() {
        while (true) {
            int ans = (rand7() - 1) * 7 + (rand7() - 1); // 进制转换
            if (1 <= ans && ans <= 10) return ans;
        }
    }

    public static void main(String[] args) {
        Rand10Solution solution = new Rand10Solution();
        for (int i = 0; i < 100; i++) {
            if (i != 0 && i % 10 == 0) {
                System.out.println("");
            }
            System.out.print(solution.rand10() + ",");
        }
    }
}
