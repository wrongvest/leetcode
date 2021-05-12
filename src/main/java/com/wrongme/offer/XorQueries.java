package com.wrongme.offer;

import java.util.Arrays;

public class XorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int temp = 0;
            int start = queries[i][0];
            for (int j = queries[i][0]; j < queries[i][1]; j++) {
                if (start == j) {
                    temp = arr[j] ^ arr[j + 1];
                }else {
                    temp^= arr[j+1];
                }
            }
            if (queries[i][0] == queries[i][1] ){
                temp = arr[queries[i][0]];
            }
            result[i] = temp;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 8};
        int queries[][] = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        XorQueries xor = new XorQueries();
//        System.out.println(queries.length);
//        System.out.println(queries[0].length);
        Arrays.stream( xor.xorQueries(arr,queries)).forEach(System.out::println);
    }
}
