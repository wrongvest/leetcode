package com.wrongme.daily.w20211112;

/**
 * 458. 可怜的小猪
 */
public class PoorPigs {
    // ans = ceil(log(buckets) / log(base))
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int base = (minutesToTest/minutesToDie) +1;
        double temp = Math.log(buckets) / Math.log(base);
        return (int) Math.ceil(temp);
    }
}
