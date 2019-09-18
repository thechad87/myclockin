package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.TimeAndDateStamp.DateTracker;
import com.chadmarthinussen.repository.DateTrackerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@Repository("DateTrackerRepositoryImpl")
public class DateTrackerRepositoryImpl implements DateTrackerRepository {

    private static DateTrackerRepositoryImpl repository = null;
    private Set<DateTracker> dateTrackers;

    private DateTrackerRepositoryImpl(){
        this.dateTrackers = new HashSet<>();
    }

    private DateTracker findDateTracker(String dateTrackerID) {
        return this.dateTrackers.stream()
                .filter(dateTracker -> dateTracker.getDatetrackerID().trim().equals(dateTrackerID))
                .findAny()
                .orElse(null);
    }

    public static DateTrackerRepositoryImpl getRepository(){
        if (repository == null) repository = new DateTrackerRepositoryImpl();
        return repository;
    }


    public DateTracker create(DateTracker dateTracker){
        this.dateTrackers.add(dateTracker);
        return dateTracker;
    }

    public DateTracker read(final String dateTrackerID){
        DateTracker dateTracker = findDateTracker(dateTrackerID);
        return dateTracker;
    }

    public void delete(String dateTrackerID) {
        DateTracker dateTracker = findDateTracker(dateTrackerID);
        if (dateTracker != null) this.dateTrackers.remove(dateTracker);
    }

    public DateTracker update(DateTracker dateTracker){
        DateTracker toDelete = findDateTracker(dateTracker.getDatetrackerID());
        if(toDelete != null) {
            this.dateTrackers.remove(toDelete);
            return create(dateTracker);
        }
        return null;
    }


    public Set<DateTracker> getAll(){
        return this.dateTrackers;
    }
}