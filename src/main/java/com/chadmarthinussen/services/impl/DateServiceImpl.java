package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.AccessTypes.Date;
import com.chadmarthinussen.repository.DateRepository;
import com.chadmarthinussen.repository.impl.DateRepositoryImpl;
import com.chadmarthinussen.services.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("DateServiceImpl")
//@Service
public class DateServiceImpl implements DateService {

    private static DateServiceImpl service = null;
    @Autowired
    private DateRepository repository;

    private DateServiceImpl() {
        this.repository = DateRepositoryImpl.getRepository();
    }

    public static DateServiceImpl getService() {
        if (service == null) service = new DateServiceImpl();
        return service;
    }

    @Override
    public Date create(Date date) {
        return this.repository.create(date);
    }

    @Override
    public Date update(Date date) {
        return this.repository.update(date);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Date read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set <Date> getAll() {
        return this.repository.getAll();
    }
}
