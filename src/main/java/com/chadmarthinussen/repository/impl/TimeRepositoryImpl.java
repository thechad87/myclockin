package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.AccessTypes.Time;
import com.chadmarthinussen.repository.TimeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Repository("TimeRepositoryImpl")
public class TimeRepositoryImpl implements TimeRepository {

    private static TimeRepositoryImpl repository = null;
    private Set<Time> times;

    private TimeRepositoryImpl(){
        this.times = new HashSet<>();
    }

    private Time findTime(String timeID) {
        return this.times.stream()
                .filter(time -> time.getTimeID().trim().equals(timeID))
                .findAny()
                .orElse(null);
    }

    public static TimeRepositoryImpl getRepository(){
        if (repository == null) repository = new TimeRepositoryImpl();
        return repository;
    }


    public Time create(Time time){
        this.times.add(time);
        return time;
    }

    public Time read(final String timeID){
        Time time = findTime(timeID);
        return time;
    }

    public void delete(String timeID) {
        Time time = findTime(timeID);
        if (time != null) this.times.remove(time);
    }

    public Time update(Time time){
        Time toDelete = findTime(time.getTimeID());
        if(toDelete != null) {
            this.times.remove(toDelete);
            return create(time);
        }
        return null;
    }


    public Set<Time> getAll(){
        return this.times;
    }
}
