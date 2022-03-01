package com.wrongme.daily.w20220228;

public class TuesdaySolution {
    public String convert(String s, int numRows) {
        if (numRows>s.length() || numRows==1){
            return s;
        }
        int row = 0;
        int col = 0;
        char[][] chars = new char[numRows][1005];
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            if (down) {
                chars[row++][col] = s.charAt(i);
                if (row == numRows) {
                    down = false;
                    col++;
                    row = row - 2;
                }
            } else {
                chars[row--][col++] = s.charAt(i);
                if (row == -1) {
                    row = row + 2;
                    down = true;
                    // 保持在当前列
                    col--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                sb.append(chars[i][j]=='\u0000'?"":chars[i][j]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TuesdaySolution tuesdaySolution = new TuesdaySolution();
//        System.out.println(tuesdaySolution.convert("PAYPALISHIRING", 3));
//        System.out.println(tuesdaySolution.convert("PAYPALISHIRING", 4));
        System.out.println(tuesdaySolution.convert("AB", 1));
    }
}
