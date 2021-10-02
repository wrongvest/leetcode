package com.wrongme.daily.w20211001;

/**
 * 405. 数字转换为十六进制数
 */
public class ToHexSolution {
    public String toHex(int _num) {
        String ans = "";
        long num = _num;
        if (num<0){
            num = (long) (Math.pow(2,32)+_num);
        }else if (num==0){
            return 0+"";
        }
        while (num !=0) {
            long mod = num % 16;
            if (mod>=10){
                char m = (char) (mod -10 +'a');
                ans = m +ans;
            }else {
                ans = mod +ans;
            }

            num = num/16;
        }
        return ans;
    }

    public static void main(String[] args) {
        ToHexSolution solution = new ToHexSolution();
        System.out.println(solution.toHex(26));
        System.out.println(solution.toHex(-1));
    }

}
