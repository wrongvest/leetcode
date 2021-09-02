package com.wrongme.daily.w20210831;

public class CorpFlightBookingsSolution {
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            for (int i = 0; i < (booking[1] - booking[0]) + 1; i++) {
                ans[booking[0] + i - 1] += booking[2];
            }
        }
        return ans;
    }

    public int[] corpFlightBookings(int[][] bs, int n) {
        int[] c = new int[n + 1];
        for (int[] b : bs) {
            c[b[0] - 1] += b[2];
            if (b[1] < n) {
                c[b[1]] -= b[2];
            }
        }
        for (int i = 1; i < n; i++) {
            c[i] += c[i - 1];
        }
        return c;
    }

    public static void main(String[] args) {
        CorpFlightBookingsSolution solution = new CorpFlightBookingsSolution();
        solution.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2);
//        solution.corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}},5);
    }
}
