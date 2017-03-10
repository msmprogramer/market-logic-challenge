package com.marketlogicchallenge.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by msalama on 3/10/17.
 */

public class Utils {

    public static String getTodayDate() {

        String dateString = new SimpleDateFormat("MM/dd/yyyy").format(new Date());

        return dateString;
    }
}
