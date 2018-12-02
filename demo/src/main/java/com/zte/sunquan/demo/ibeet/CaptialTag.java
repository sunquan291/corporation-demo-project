package com.zte.sunquan.demo.ibeet;

/**
 * Created by 10184538 on 2017/3/24.
 */
public class CaptialTag {

    public String captial(String tag) {
        tag = tag.substring(0, 1).toUpperCase() + tag.substring(1);
        return restrictConsecutiveCapitalCase(tag);
    }

    private static String restrictConsecutiveCapitalCase(String tag) {
        for (int k = 0; k < tag.length(); k++) {
            if (k + 1 < tag.length()) {
                if (Character.isUpperCase(tag.charAt(k))) {
                    if (Character.isUpperCase(tag.charAt(k + 1))) {
                        tag = tag.substring(0, k + 1)
                                + tag.substring(k + 1, k + 2).toLowerCase()
                                + tag.substring(k + 2);
                    }
                }
            }
        }
        return tag;
    }
}
