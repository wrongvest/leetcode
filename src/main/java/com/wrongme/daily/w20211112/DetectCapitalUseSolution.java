package com.wrongme.daily.w20211112;

public class DetectCapitalUseSolution {
    public boolean detectCapitalUse(String word) {
        if (word.toLowerCase().equals(word)){
            return true;
        }
        if (word.toUpperCase().equals(word)){
            return true;
        }
        if (word.charAt(0)>='A'&& word.charAt(0)<='Z'){
            String temp = word.substring(1);
            return temp.toLowerCase().equals(temp);
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCapitalUseSolution solution = new DetectCapitalUseSolution();
        System.out.println(solution.detectCapitalUse("USA"));
        System.out.println(solution.detectCapitalUse("USa"));
        System.out.println(solution.detectCapitalUse("Usa"));
        System.out.println(solution.detectCapitalUse("asa"));
        System.out.println(solution.detectCapitalUse("FsaA"));
    }
}
