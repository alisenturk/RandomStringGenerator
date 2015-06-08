/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author asenturk
 */
public class Util {

    public static String getTodayDate(String type) { // type

        String resultStr = null;

        Calendar cal = new GregorianCalendar();
        Date trialTime = new Date();
        cal.setTime(trialTime);

        int hour = cal.get(Calendar.HOUR_OF_DAY);       // 0..23
        int min = cal.get(Calendar.MINUTE);             // 0..59
        int sec = cal.get(Calendar.SECOND);             // 0..59

        String hourStr = "" + hour;
        int hourLenght = hourStr.length();
        if (hourLenght == 1) {
            hourStr = "0" + hourStr;
        }

        String minStr = "" + min;
        int minLenght = minStr.length();
        if (minLenght == 1) {
            minStr = "0" + minStr;
        }

        String secStr = "" + sec;
        int secLenght = secStr.length();
        if (secLenght == 1) {
            secStr = "0" + secStr;
        }

        int monthInt = cal.get(Calendar.MONTH) + 1;
        int weekDayInt = cal.get(Calendar.DAY_OF_WEEK);

        String dayStr = "" + cal.get(Calendar.DAY_OF_MONTH);
        String monthStr = "" + monthInt;
        String yearStr = "" + cal.get(Calendar.YEAR);

        if (dayStr.length() == 1) {
            dayStr = "0" + dayStr;
        }
        if (monthStr.length() == 1) {
            monthStr = "0" + monthStr;
        }

        if (type.equals("time")) {
            resultStr = hourStr + ":" + minStr;
        } else if (type.equals("ddmmyyyyhhmi")) {
            resultStr = dayStr + monthStr + yearStr + hourStr + minStr;
        } else if (type.equals("yyyymmdd")) {
            resultStr = yearStr + monthStr + dayStr;
        } else if (type.equals("yyyymmddhhmi")) {
            resultStr = yearStr + monthStr + dayStr+hourStr+minStr;
        } else {
            resultStr = dayStr + "/" + monthStr + "/" + yearStr;
        }

        return resultStr;
    }
}
