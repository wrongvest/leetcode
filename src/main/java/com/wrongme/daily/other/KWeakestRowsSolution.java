package com.wrongme.daily.other;

import java.util.Arrays;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 */
public class KWeakestRowsSolution {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] ability = new int[mat.length][1];
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                sum += mat[i][j];
            }
            ability[i] = new int[]{sum, i};
        }
        Arrays.sort(ability,(a,b)->{
            if (a[0]!=b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = ability[i][1];
        }
        return ans;
    }

}
