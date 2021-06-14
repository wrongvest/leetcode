package com.wrongme.daily;

public class GuessGameSolution extends GuessGame {

    public int guessNumber(int n) {
        int left = 1, right = n;
        // 循环直至区间左右端点相同
        while (left < right) {
            int mid = (left + (right - left))>> 2;
            if (guess(mid) <= 0) {
                // 答案在区间 [left, mid] 中
                right = mid;
            }else {
                // 答案在区间 [mid+1, right] 中
                left = mid+1;
            }
        }
        // left == right，区间缩为一个点，即为答案
        return left;
    }


    public static void main(String[] args) {
        GuessGameSolution solution = new GuessGameSolution();
        System.out.println(solution.guessNumber(10));
    }
}

class GuessGame {
    static int pick = 6;

    int guess(int num) {
        if (num > pick) {
            return 1;
        } else if (num < pick) {
            return -1;
        }
        return 0;
    }
}