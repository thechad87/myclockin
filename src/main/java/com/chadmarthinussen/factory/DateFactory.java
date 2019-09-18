package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.AccessTypes.Date;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */
public class DateFactory {


    public static Date buildDate(String dateID, String day, String month, String year){
        return new Date.Builder().dateID(dateID).day(day).month(month).year(year).build();
    }
}


