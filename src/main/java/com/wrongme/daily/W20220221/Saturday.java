package com.wrongme.daily.W20220221;

/**
 * 838. 推多米诺
 */
public class Saturday {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int i = 0;
        while (i < arr.length) {
            // 跳过非 . 字符
            while (i < arr.length && arr[i] != '.') {
                i++;
            }
            int j = i;
            // 取 连续的 .
            while (j < arr.length && arr[j] == '.') {
                j++;
            }
            replace(arr, i, j - 1);
            i = j;
        }
        return new String(arr);
    }

    private void replace(char[] arr, int start, int end) {
        // 如果两头都是R，全部替换成R
        // 如果左边是R，右边是边界，全部替换成R
        // 如果两头都是L，全部替换成L
        // 如果左边是边界，右边是L，全部替换成L
        // 如果左边是R，右边是L，除了最中间那个.，其他的都需要替换
        // 其他情况保持不变
        if (start - 1 >= 0 && arr[start-1] == 'R' && (end + 1 >= arr.length || arr[end + 1] == 'R')) {
            while (start <= end) {
                arr[start++] = 'R';
                arr[end--] = 'R';
            }
        } else if (end + 1 < arr.length && arr[end + 1] == 'L' && (start - 1 < 0 || arr[start - 1] == 'L')) {
            while (start <= end) {
                arr[start++] = 'L';
                arr[end--] = 'L';
            }
        } else if (start - 1 >= 0 && end + 1 < arr.length && arr[start - 1] == 'R' && arr[end + 1] == 'L') {
            while (start < end) {
                arr[start++] = 'R';
                arr[end--] = 'L';
            }
        }
    }

    public static void main(String[] args) {
        Saturday saturday = new Saturday();
        System.out.println(saturday.pushDominoes("RR.L"));
        System.out.println(saturday.pushDominoes(".L.R...LR..L.."));
    }
}
