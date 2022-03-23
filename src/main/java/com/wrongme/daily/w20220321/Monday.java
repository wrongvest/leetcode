package com.wrongme.daily.w20220321;

public class Monday {
    public int findKthNumber(int n, int k) {
        long p = 1;
        int prefix = 1;
        while (p < k) {
            long count = getCount(prefix, n);
            if (p + count > k) {
                //  说明第k个数，在这个前缀范围里面
                prefix *= 10;
                p++;
            } else {
                // 说明第k个数，不在这个前缀范围里面，前缀需要扩大+1
                prefix++;
                p += count;
            }
        }
        return prefix;
    }

    long getCount(long prefix, long n) {
        long cur = prefix;
        long next = cur + 1;
        long count = 0;
        while (n >= cur) {
            // 下一个前缀的起点减去当前前缀的起点，那么就是当前前缀下的所有子节点数总和
            count += Math.min(next, n + 1) - cur;
            cur = cur * 10;
            next = next * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Monday monday = new Monday();
        System.out.println(monday.findKthNumber(13, 2));
    }
}
