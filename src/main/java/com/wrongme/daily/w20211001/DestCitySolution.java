package com.wrongme.daily.w20211001;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestCitySolution {

    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        paths.forEach(path->{
            String start = path.get(0);
            String end = path.get(1);
            set.add(start);
            set.add(end);
        });
        paths.forEach(path->{
            String start = path.get(0);
            set.remove(start);
        });
        return set.stream().findFirst().get();
    }

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        List<String> path1 = new ArrayList<>();
        path1.add("A");
        path1.add("B");
        paths.add(path1);
        List<String> path2 = new ArrayList<>();
        path2.add("B");
        path2.add("C");
        paths.add(path2);
        DestCitySolution solution = new DestCitySolution();
        System.out.println(solution.destCity(paths));
    }
}
