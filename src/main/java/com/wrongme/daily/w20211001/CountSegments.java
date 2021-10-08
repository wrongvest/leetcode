package com.wrongme.daily.w20211001;

public class CountSegments {
    public int countSegments(String s) {
        if (s.length()==0){
            return 0;
        }
        return s.split(" ").length;
    }

    public static void main(String[] args) {
        CountSegments segments= new CountSegments();
        System.out.println(segments.countSegments("Hello, my name is John"));
        System.out.println(segments.countSegments(""));
        System.out.println(segments.countSegments(", , , ,        a, eaefa"));
    }
}
