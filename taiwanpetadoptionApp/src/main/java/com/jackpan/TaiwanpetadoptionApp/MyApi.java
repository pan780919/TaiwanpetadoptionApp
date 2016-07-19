package com.jackpan.TaiwanpetadoptionApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by HYXEN20141227 on 2016/6/24.
 */
public class MyApi {

    public static long getTime(String dateTime){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
            Date date = sdf.parse(dateTime);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
