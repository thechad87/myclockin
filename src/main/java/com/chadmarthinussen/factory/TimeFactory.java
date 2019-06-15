package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.AccessTypes.Time;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */
public class TimeFactory {


    public static Time buildTime(String timeID, String seconds, String minutes, String hours){
        return new Time.Builder().timeID(timeID).seconds(seconds).minutes(minutes).hours(hours).build();
    }
}
