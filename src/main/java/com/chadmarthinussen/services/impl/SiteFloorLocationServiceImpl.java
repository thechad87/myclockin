package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.Domain.Location.SiteFloorLocation;
import com.chadmarthinussen.repository.SiteFloorLocationRepository;
import com.chadmarthinussen.repository.impl.SiteFloorLocationRepositoryImpl;
import com.chadmarthinussen.services.SiteFloorLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@Service("SiteFloorLocationServiceImpl")
public class SiteFloorLocationServiceImpl implements SiteFloorLocationService {

    @Autowired
    private SiteFloorLocationRepository repository;
    private static SiteFloorLocationServiceImpl service = null;

    private SiteFloorLocationServiceImpl() {
        this.repository = SiteFloorLocationRepositoryImpl.getRepository();
    }

    public static SiteFloorLocationServiceImpl getService(){
        if (service == null) service = new SiteFloorLocationServiceImpl();
        return service;
    }

    @Override
    public SiteFloorLocation create(SiteFloorLocation siteFloorLocation) {
        return this.repository.create(siteFloorLocation);
    }

    @Override
    public SiteFloorLocation update(SiteFloorLocation siteFloorLocation) {
        return this.repository.update(siteFloorLocation);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public SiteFloorLocation read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<SiteFloorLocation> getAll() {
        return this.repository.getAll();
    }
}
