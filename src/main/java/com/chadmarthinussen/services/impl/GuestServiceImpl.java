package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.UserlType.Guest;
import com.chadmarthinussen.repository.GuestRepository;
import com.chadmarthinussen.repository.impl.GuestRepositoryImpl;
import com.chadmarthinussen.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("GuestServiceImpl")
//@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository repository;
    private static GuestServiceImpl service = null;


    private GuestServiceImpl() {
        this.repository = GuestRepositoryImpl.getRepository();
    }

    public static GuestServiceImpl getService(){
        if (service == null) service = new GuestServiceImpl();
        return service;
    }

    @Override
    public Guest create(Guest guest) {
        return this.repository.create(guest);
    }

    @Override
    public Guest update(Guest guest) {
        return this.repository.update(guest);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Guest read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Guest retrieveByDesc(String genderDesc) {
        return this.repository.retrieveByDesc(genderDesc);
    }
    @Override
    public Set<Guest> getAll() {
        return this.repository.getAll();
    }
}
