package com.wrongme.daily.other;

/**
 * 1736. 替换隐藏数字得到的最晚时间
 */
public class MaximumTimeSolution {

    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        char c0 = time.charAt(0);
        char c1 = time.charAt(1);
        char c3 = time.charAt(3);
        char c4 = time.charAt(4);
        if ( c0 == '?') {
            if (c1=='?'){
                sb.append("23");
            }else if (c1=='0'||c1=='1'||c1=='2'||c1=='3'){
                sb.append(2).append(c1);
            }else {
                sb.append(1).append(c1);
            }
        }else {
            sb.append(c0);
            if (c1=='?') {
                if (c0 == '0' || c0 == '1') {
                    sb.append(9);
                } else {
                    sb.append(3);
                }
            }else {
                sb.append(c1);
            }
        }

        sb.append(":");
        if (c3=='?'){
            sb.append(5);
        }else {
            sb.append(c3);
        }
        if (c4=='?'){
            sb.append(9);
        }else {
            sb.append(c4);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MaximumTimeSolution solution = new MaximumTimeSolution();
        System.out.println(solution.maximumTime("2?:?0"));
        System.out.println(solution.maximumTime("0?:3?"));
        System.out.println(solution.maximumTime("1?:22"));
    }
}
