package com.dragovorn.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: update to a SimpleDateFormat type thing
public class DateHelper {

    private static SimpleDateFormat first = new SimpleDateFormat("EEE, MMM ");
    private static SimpleDateFormat second = new SimpleDateFormat("d");
    private static SimpleDateFormat third = new SimpleDateFormat(" yyyy 'at' hh:mm a");

    public static String readableDate(Date date) {
        String str = first.format(date);

        int day = Integer.valueOf(second.format(date));

        switch (day) {
            case 1:
            case 21:
            case 31:
                str += day + "st";
                break;
            case 2:
            case 22:
                str += day + "nd";
                break;
            case 3:
            case 23:
                str += day + "rd";
                break;
            default:
                str += day + "th";
        }

        str += "," + third.format(date);

        return str;
    }
}