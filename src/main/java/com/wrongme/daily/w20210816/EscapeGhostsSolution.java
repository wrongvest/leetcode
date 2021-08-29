package com.wrongme.daily.w20210816;

public class EscapeGhostsSolution {

    private int distance(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int cur = distance(0,0,target[0],target[1]);
        for (int[] ghost : ghosts) {
            if (distance(ghost[0],ghost[1],target[0],target[1])<=cur){
                return false;
            }
        }
        return true;
    }
}
