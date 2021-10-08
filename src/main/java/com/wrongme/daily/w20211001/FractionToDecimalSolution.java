package com.wrongme.daily.w20211001;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FractionToDecimalSolution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator,b = denominator;
        if (a%b==0){
            return a/b +"";
        }
        StringBuilder sb = new StringBuilder();
        // 处理负数
        if (a*b<0){
            sb.append("-");
        }
        a =Math.abs(a);
        b =Math.abs(b);
        sb.append(a / b).append(".");
        a= a%b;
        Map<Long,Integer> map = new HashMap<>();
        while (a!=0){
            map.put(a,sb.length());
            a = a*10;
            sb.append(a/b);
            a = a%b;
            if (map.containsKey(a)){
                int u = map.get(a);
//                sb.append("(").append(sb.substring(u-1,sb.length())).append(")");
              return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToDecimalSolution solution = new FractionToDecimalSolution();
        System.out.println(solution.fractionToDecimal(2, 3));
        System.out.println(solution.fractionToDecimal(-50, 8));
    }
}
