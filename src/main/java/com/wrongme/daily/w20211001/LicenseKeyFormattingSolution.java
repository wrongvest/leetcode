package com.wrongme.daily.w20211001;

import java.util.Locale;

public class LicenseKeyFormattingSolution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder(s.toUpperCase());
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '-') {
                sb.delete(i, i + 1);
                i--;
            }
        }
        int first = sb.length() % k;
        for (int i = 0, j = 0; i < sb.length(); i++) {
            if ((i == first && i != 0) || j == k) {
                sb.insert(i, '-');
                i++;
                j=0;
            }
            j++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormattingSolution solution = new LicenseKeyFormattingSolution();
        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-w", 3));
        System.out.println(solution.licenseKeyFormatting("2-5g-3-J", 2));
    }
}
