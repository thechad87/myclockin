package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.TimeAndDateStamp.TimeTracker;
import com.chadmarthinussen.repository.TimeTrackerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */

@Repository("TimeTrackerRepositoryImpl")
public class TimeTrackerRepositoryImpl implements TimeTrackerRepository {

    private static TimeTrackerRepositoryImpl repository = null;
    private Set<TimeTracker> timeTrackers;

    private TimeTrackerRepositoryImpl(){
        this.timeTrackers = new HashSet<>();
    }

    private TimeTracker findTimeTracker(String timeTrackerID) {
        return this.timeTrackers.stream()
                .filter(timeTracker -> timeTracker.getTimeTrackerID().trim().equals(timeTrackerID))
                .findAny()
                .orElse(null);
    }

    public static TimeTrackerRepositoryImpl getRepository(){
        if (repository == null) repository = new TimeTrackerRepositoryImpl();
        return repository;
    }


    public TimeTracker create(TimeTracker timeTracker){
        this.timeTrackers.add(timeTracker);
        return timeTracker;
    }

    public TimeTracker read(final String timeTrackerID){
        TimeTracker timeTracker = findTimeTracker(timeTrackerID);
        return timeTracker;
    }

    public void delete(String timeTrackerID) {
        TimeTracker timeTracker = findTimeTracker(timeTrackerID);
        if (timeTracker != null) this.timeTrackers.remove(timeTracker);
    }

    public TimeTracker update(TimeTracker timeTracker){
        TimeTracker toDelete = findTimeTracker(timeTracker.getTimeTrackerID());
        if(toDelete != null) {
            this.timeTrackers.remove(toDelete);
            return create(timeTracker);
        }
        return null;
    }


    public Set<TimeTracker> getAll(){
        return this.timeTrackers;
    }
}