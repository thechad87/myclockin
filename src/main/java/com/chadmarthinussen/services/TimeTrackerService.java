package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.TimeAndDateStamp.TimeTracker;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface TimeTrackerService extends IService<TimeTracker, String> {
        Set<TimeTracker> getAll();
}
