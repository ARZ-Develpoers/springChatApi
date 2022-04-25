package com.project.springchatapi2.util;

import java.util.Arrays;

public class SortUtil {

    public static String sort(String sort, String[] fields, String defaultVal) {

        String[] columns = sort.split(",",-1);
        StringBuffer sb = new StringBuffer();

        for (String column : columns) {
            if (!Arrays.asList(fields).contains(column.trim().toLowerCase())) {
                column=defaultVal;
            }
            else {
                if (column.endsWith("+")) {
                    sb.append(column.substring(0, column.length() - 1)).append(" ").append("ASC").append(",");

                } else if (column.endsWith("-")) {
                    sb.append(column.substring(0, column.length() - 1)).append(" ").append("DESC").append(",");
                } else {
                    sb.append(column).append(" ").append("ASC").append(",");
                }
            }


        }

        if (sb.toString().length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        else {
            //sb.append("occur_datetime DESC");
        }

        return sb.toString();
    }
}
