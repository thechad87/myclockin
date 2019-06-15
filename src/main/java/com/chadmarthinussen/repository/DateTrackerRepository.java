package com.chadmarthinussen.repository;

import com.chadmarthinussen.Domain.TimeAndDateStamp.DateTracker;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public interface DateTrackerRepository extends IRepository<DateTracker,String> {
    Set<DateTracker> getAll();
}
