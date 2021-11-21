package com.wrongme.daily.w20211112;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacementSolution {
    Map<Long,Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        return dfs(n);
    }

    private int dfs(long n) {
        if (n==1){
            return 0;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        int ans = n%2==0? dfs(n/2) :Math.min(dfs(n-1),dfs(n+1));
        map.put(n,++ans);
        return ans;
    }

    public static void main(String[] args) {
        IntegerReplacementSolution solution = new IntegerReplacementSolution();
        System.out.println(solution.integerReplacement(2147483647));
    }
}
