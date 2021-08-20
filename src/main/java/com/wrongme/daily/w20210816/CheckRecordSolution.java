package com.wrongme.daily.w20210816;

public class CheckRecordSolution {
    int mod = (int) (1e9 + 7);
    int [][][] cache ;
    public int checkRecord(int n) {
        cache = new int[n][2][3];
        return dfs(0, n, 0, 0);
    }

    //按 总出勤 计，学生缺勤（'A'）严格 少于两天。
    //学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
    int dfs(int day, int n, int absent, int late) {
        if (day >= n) {
            return 1;
        }
        if (cache[day][absent][late]!=0){
            return cache[day][absent][late];
        }
        int ans = 0;
        // 1. present
        ans = (ans + dfs(day + 1, n, absent, 0)) % mod;
        // 2.缺席1天
        if (absent < 1) {
            ans = (ans + dfs(day + 1, n, 1, 0)) % mod;
        }
        // 3.连续迟到2天
        if (late < 2) {
            ans =(ans +dfs(day+1,n,absent,late+1))%mod;
        }
        cache[day][absent][late] = ans;
        return ans;
    }

    public static void main(String[] args) {
        CheckRecordSolution solution = new CheckRecordSolution();
        solution.checkRecord(2);
}


}
