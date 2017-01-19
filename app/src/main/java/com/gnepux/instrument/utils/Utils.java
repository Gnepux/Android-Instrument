package com.gnepux.instrument.utils;

/**
 * Created by xupeng on 17/1/18.
 */

public class Utils {

    public static String getStringValue(Object[] t) {
        String value = "";
        StringBuilder sb = new StringBuilder();
        for (Object str : t) {
            sb.append(str + ",");
        }
        value = sb.toString().substring(0, sb.toString().length() - 1);
        return value;
    }

}
