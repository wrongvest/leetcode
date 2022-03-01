package com.wrongme.daily.w20220228;

/**
 * 1601. 最多可达成的换楼请求数目
 */
public class MondaySolution {
    public int maximumRequests(int n, int[][] requests) {
        int ans = 0;
        int m = requests.length;
        for (int i = 0; i < (1 << m); i++) {
            int bitCount = Integer.bitCount(i);
            if (bitCount < ans) {
                continue;
            }
            if (check(i, n, requests)) {
                ans = bitCount;
            }
        }
        return ans;
    }

    private boolean check(int mask, int n, int[][] requests) {
        int m = requests.length;
        int[] delta = new int[n];
        for (int i = 0; i < m; i++) {
            if (((mask >> i) & 1) == 1) {
                delta[requests[i][0]]--;
                delta[requests[i][1]]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (delta[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MondaySolution mondaySolution = new MondaySolution();
//        System.out.println(mondaySolution.maximumRequests(5,new int[][]{{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}}));
        System.out.println(mondaySolution.maximumRequests(5,new int[][]{{0,0},{1,2},{2,1}}));
    }
}
