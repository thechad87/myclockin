package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.AccessTypes.Date;
import com.chadmarthinussen.domain.TimeAndDateStamp.DateTracker;

/**
 * Created by ChadMarthinussen2 on 2019/05/20.
 */
public class DateTrackerFactory {

    public static DateTracker buildDateTracker(String dateTrackerID, String timestamp,Date date){
        return new DateTracker.Builder().dateTrackerID(dateTrackerID).timestamp(timestamp).date(date).build();
    }
}
