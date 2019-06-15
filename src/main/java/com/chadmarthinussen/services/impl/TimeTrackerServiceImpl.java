package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.Domain.TimeAndDateStamp.TimeTracker;
import com.chadmarthinussen.repository.TimeTrackerRepository;
import com.chadmarthinussen.repository.impl.TimeTrackerRepositoryImpl;
import com.chadmarthinussen.services.TimeTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("TimeTrackerServiceImpl")
public class TimeTrackerServiceImpl implements TimeTrackerService {

    @Autowired
    private TimeTrackerRepository repository;
    private static TimeTrackerServiceImpl service = null;

    private TimeTrackerServiceImpl() {
        this.repository = TimeTrackerRepositoryImpl.getRepository();
    }

    public static TimeTrackerServiceImpl getService(){
        if (service == null) service = new TimeTrackerServiceImpl();
        return service;
    }

    @Override
    public TimeTracker create(TimeTracker timeTracker) {
        return this.repository.create(timeTracker);
    }

    @Override
    public TimeTracker update(TimeTracker timeTracker) {
        return this.repository.update(timeTracker);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public TimeTracker read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<TimeTracker> getAll() {
        return this.repository.getAll();
    }
}
