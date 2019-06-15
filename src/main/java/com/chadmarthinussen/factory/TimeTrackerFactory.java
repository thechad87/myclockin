package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.AccessTypes.Time;
import com.chadmarthinussen.Domain.TimeAndDateStamp.TimeTracker;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */
public class TimeTrackerFactory {

    public static TimeTracker buildTimeTracker(String timeTrackerID, Time userCheckInTimer, Time userCheckOutTimer, boolean isCurrentlyCheckedIn){

        return new TimeTracker.Builder().timeTrackerID(timeTrackerID).userCheckInTimer(userCheckInTimer).userCheckOutTimer(userCheckOutTimer).isCurrentlyCheckedIn(isCurrentlyCheckedIn).build();
    }
}
