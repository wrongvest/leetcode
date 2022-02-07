package com.wrongme.daily.other;

public class CountDigitOneSolution {

    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int m = s.length();
        if (m==1){
            return n>0? 1:0;
        }
        int[] ps = new int[m];
        int[] ss = new int[m];
        ss[0] = Integer.parseInt(s.substring(1));
        for (int i = 1; i < m - 1; i++) {
            ps[i] = Integer.parseInt(s.substring(0,i));
            ss[i] = Integer.parseInt(s.substring(i+1));
        }
        ps[m-1] = Integer.parseInt(s.substring(0,m-1));
        int ans =0;
        for (int i = 0; i < m; i++) {
            // x 为当前位数值
            int x = s.charAt(i)-'0';
            // len 为当前位后面长度为多少
            int len = m-i-1;
            int prefix = ps[i];
            int suffix =ss[i];
            int tot =0;
            tot+= prefix* Math.pow(10,len);
            if (x==0){

            }else if (x==1){
                tot += suffix+1;
            }else {
                tot+= Math.pow(10,len);
            }
            ans +=tot;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountDigitOneSolution solution = new CountDigitOneSolution();
        solution.countDigitOne(13);
    }
}
