package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.Location.SiteFloorLocation;
import com.chadmarthinussen.repository.SiteFloorLocationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */

@Repository("SiteFloorLocationRepositoryImpl")
public class SiteFloorLocationRepositoryImpl implements SiteFloorLocationRepository {

    private static SiteFloorLocationRepositoryImpl repository = null;
    private Set<SiteFloorLocation> siteFloorLocations;

    private SiteFloorLocationRepositoryImpl(){
        this.siteFloorLocations = new HashSet<>();
    }

    private SiteFloorLocation findSiteFloorLocation(String siteFloorLocationID) {
        return this.siteFloorLocations.stream()
                .filter(siteFloorLocation -> siteFloorLocation.getSiteFloorLocationID().trim().equals(siteFloorLocationID))
                .findAny()
                .orElse(null);
    }

    public static SiteFloorLocationRepositoryImpl getRepository(){
        if (repository == null) repository = new SiteFloorLocationRepositoryImpl();
        return repository;
    }


    public SiteFloorLocation create(SiteFloorLocation siteFloorLocation){
        this.siteFloorLocations.add(siteFloorLocation);
        return siteFloorLocation;
    }

    public SiteFloorLocation read(final String siteFloorLocationID){
        SiteFloorLocation siteFloorLocation = findSiteFloorLocation(siteFloorLocationID);
        return siteFloorLocation;
    }

    public void delete(String siteFloorLocationID) {
        SiteFloorLocation siteFloorLocation = findSiteFloorLocation(siteFloorLocationID);
        if (siteFloorLocation != null) this.siteFloorLocations.remove(siteFloorLocation);
    }

    public SiteFloorLocation update(SiteFloorLocation siteFloorLocation){
        SiteFloorLocation toDelete = findSiteFloorLocation(siteFloorLocation.getSiteFloorLocationID());
        if(toDelete != null) {
            this.siteFloorLocations.remove(toDelete);
            return create(siteFloorLocation);
        }
        return null;
    }


    public Set<SiteFloorLocation> getAll(){
        return this.siteFloorLocations;
    }
}