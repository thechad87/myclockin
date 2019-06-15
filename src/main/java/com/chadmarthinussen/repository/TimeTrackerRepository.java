package com.chadmarthinussen.repository;

import com.chadmarthinussen.Domain.TimeAndDateStamp.TimeTracker;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
public interface TimeTrackerRepository extends IRepository<TimeTracker,String> {
    Set<TimeTracker> getAll();
}
