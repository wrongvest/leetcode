package com.wrongme.offer;

public class IsNumber {
    public boolean isNumber(String s) {
        s = s.toLowerCase().trim();
        char[] chars = s.toCharArray();
        if (chars.length==0){
            return false;
        }
        if (chars.length==1 && !(chars[0] >= '0' && chars[0] <= '9')){
            return false;
        }
        if (legalNum(s)) {
            if ((chars[0] >= '0' && chars[0] <= '9') || chars[0] == ' ' || chars[0] == '+' || chars[0] == '-') {
                boolean cotainE = false;
                boolean cotainDot = false;
                for (char ch : chars) {
                    if (ch == 'e') {
                        cotainE = true;
                    }
                    if (ch == '.') {
                        cotainDot = true;
                    }
                }
                if ((cotainDot && s.split(".").length != 2)||!myspilt(s.split("."))) {
                    return false;
                }
                if ((cotainE && s.split("e").length != 2) || !myspilt(s.split("e"))) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private boolean legalNum(String s) {
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if ((ch >= '0' && ch <= '9') || ch == ' ' || ch == '+' || ch == '-' || ch == 'e' || ch == 'E') {
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean myspilt(String[] splitSpotStr) {
        if (splitSpotStr.length > 2) {
            return false;
        } else if (splitSpotStr.length == 2) {
            char[] chars = splitSpotStr[1].toCharArray();
            if ((chars[0] >= '0' && chars[0] <= '9') || chars[0] == '+' || chars[0] == '-') {
                return isInteger(splitSpotStr[0].substring(1)) && isInteger(splitSpotStr[1].substring(1).trim());
            } else {
                return false;
            }
        } else if (splitSpotStr.length == 1) {
            if (splitSpotStr[0].length() > 1) {
                return isInteger(splitSpotStr[0].substring(1));
            } else if (splitSpotStr[0].length() == 1) {
                return isInteger(splitSpotStr[0]);
            }
        }
        return true;
    }

    boolean isInteger(String numStr) {
        char[] chars = numStr.toCharArray();
        for (char ch : chars) {
            if (!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
        return true;
    }
}
