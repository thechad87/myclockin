package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.TimeAndDateStamp.DateTracker;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */


public interface DateTrackerService extends IService<DateTracker, String> {
        Set<DateTracker> getAll();
}
