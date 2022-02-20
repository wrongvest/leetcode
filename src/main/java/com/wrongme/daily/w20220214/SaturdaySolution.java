package com.wrongme.daily.w20220214;

import java.util.ArrayList;
import java.util.List;

/**
 * 969. 煎饼排序
 */
public class SaturdaySolution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        int[] idxs = new int[n + 10];
        for (int i = 0; i < n; i++) {
            idxs[arr[i]] = i;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = n; i >=1; i--) {
            int idx = idxs[i];
            // 如果当前值 t 已在 k 上，无须进行操作；
            if (idx == i - 1) {
                continue;
            }
            // 如果当前值不在 k 上，根据当前值是否在数组头部（下标为 0）进行分情况讨论：
            if (idx != 0) {
                // 当前值不在数组头部（下标为 0），而是在idx 位置上，需要先将 [0, idx] 部分进行翻转（将 idx + 1加入答案中），
                // 这样使得当前值 t 出现数组头部（下标为 0），然后再将 [0, k] 部分进行翻转（将 k + 1 加入答案中），
                // 即可将当前值 t 放到位置 k 上。
                ans.add(idx + 1);
                reserve(arr, 0, idx, idxs);
            }
            // 当前值在数组头部（下标为 0），直接将 [0, k] 部分进行翻转（将 k + 1 加入答案中），即可将当前值 t 放到位置 k 上；
            ans.add(i);
            reserve(arr, 0, i - 1, idxs);
        }
        return ans;
    }

    private void reserve(int[] arr, int i, int j, int[] idxs) {
        while (i < j) {
            idxs[arr[i]] = j;
            idxs[arr[j]] = i;
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public static void main(String[] args) {
        SaturdaySolution solution = new SaturdaySolution();
        solution.pancakeSort(new int[]{3,2,4,1}).forEach(System.out::println);
    }
}
