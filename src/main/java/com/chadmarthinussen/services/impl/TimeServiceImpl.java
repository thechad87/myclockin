package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.AccessTypes.Time;
import com.chadmarthinussen.repository.TimeRepository;
import com.chadmarthinussen.repository.impl.TimeRepositoryImpl;
import com.chadmarthinussen.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("TimeServiceImpl")
//@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeRepository repository;
    private static TimeServiceImpl service = null;

    private TimeServiceImpl() {
        this.repository = TimeRepositoryImpl.getRepository();
    }

    public static TimeServiceImpl getService(){
        if (service == null) service = new TimeServiceImpl();
        return service;
    }

    @Override
    public Time create(Time time) {
        return this.repository.create(time);
    }

    @Override
    public Time update(Time time) {
        return this.repository.update(time);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Time read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Time> getAll() {
        return this.repository.getAll();
    }
}
