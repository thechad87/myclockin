package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.TimeAndDateStamp.DateTracker;
import com.chadmarthinussen.repository.DateTrackerRepository;
import com.chadmarthinussen.repository.impl.DateTrackerRepositoryImpl;
import com.chadmarthinussen.services.DateTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("DateTrackerServiceImpl")
//@Service
public class DateTrackerServiceImpl implements DateTrackerService {


    private static DateTrackerServiceImpl service = null;
    @Autowired
    private DateTrackerRepository repository;


    private DateTrackerServiceImpl() {
        this.repository = DateTrackerRepositoryImpl.getRepository();
    }

    public static DateTrackerServiceImpl getService(){
        if (service == null) service = new DateTrackerServiceImpl();
        return service;
    }

    @Override
    public DateTracker create(DateTracker dateTracker) {
        return this.repository.create(dateTracker);
    }

    @Override
    public DateTracker update(DateTracker dateTracker) {
        return this.repository.update(dateTracker);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public DateTracker read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<DateTracker> getAll() {
        return this.repository.getAll();
    }
}