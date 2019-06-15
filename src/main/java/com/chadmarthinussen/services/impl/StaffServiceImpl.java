package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.Domain.UserlType.Staff;
import com.chadmarthinussen.repository.StaffRepository;
import com.chadmarthinussen.repository.impl.StaffRepositoryImpl;
import com.chadmarthinussen.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("StaffServiceImpl")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository repository;
    private static StaffServiceImpl service = null;

    private StaffServiceImpl() {
        this.repository = StaffRepositoryImpl.getRepository();
    }

    public static StaffServiceImpl getService(){
        if (service == null) service = new StaffServiceImpl();
        return service;
    }

    @Override
    public Staff create(Staff staff) {
        return this.repository.create(staff);
    }

    @Override
    public Staff update(Staff staff) {
        return this.repository.update(staff);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Staff read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Staff> getAll() {
        return this.repository.getAll();
    }
}
