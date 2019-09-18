package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.Location.SiteLocation;
import com.chadmarthinussen.repository.SiteLocationRepository;
import com.chadmarthinussen.repository.impl.SiteLocationRepositoryImpl;
import com.chadmarthinussen.services.SiteLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("SiteLocationServiceImpl")
//@Service
public class SiteLocationServiceImpl implements SiteLocationService {

    @Autowired
    private SiteLocationRepository repository;
    private static SiteLocationServiceImpl service = null;

    private SiteLocationServiceImpl() {
        this.repository = SiteLocationRepositoryImpl.getRepository();
    }

    public static SiteLocationServiceImpl getSiteLocoationService() {
        if (service == null) service = new SiteLocationServiceImpl();
        return service;
    }

    @Override
    public SiteLocation create(SiteLocation siteLocation) {
        return this.repository.create(siteLocation);
    }

    @Override
    public SiteLocation update(SiteLocation siteLocation) {
        return this.repository.update(siteLocation);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public SiteLocation read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set <SiteLocation> getAll() {
        return this.repository.getAll();
    }
}
