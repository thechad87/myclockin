package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.Location.SiteLocation;
import com.chadmarthinussen.repository.SiteLocationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@Repository("SiteLocationRepositoryImpl")
public class SiteLocationRepositoryImpl implements SiteLocationRepository {

    private static SiteLocationRepositoryImpl repository = null;
    private Set<SiteLocation> siteLocations;

    private SiteLocationRepositoryImpl(){
        this.siteLocations = new HashSet<>();
    }

    private SiteLocation findSiteLocation(String siteLocationID) {
        return this.siteLocations.stream()
                .filter(siteLocation -> siteLocation.getSiteLocationID().trim().equals(siteLocationID))
                .findAny()
                .orElse(null);
    }

    public static SiteLocationRepositoryImpl getRepository(){
        if (repository == null) repository = new SiteLocationRepositoryImpl();
        return repository;
    }


    public SiteLocation create(SiteLocation siteLocation){
        this.siteLocations.add(siteLocation);
        return siteLocation;
    }

    public SiteLocation read(final String siteLocationID){
        SiteLocation siteLocation = findSiteLocation(siteLocationID);
        return siteLocation;
    }

    public void delete(String siteLocationID) {
        SiteLocation siteLocation = findSiteLocation(siteLocationID);
        if (siteLocation != null) this.siteLocations.remove(siteLocation);
    }

    public SiteLocation update(SiteLocation siteLocation){
        SiteLocation toDelete = findSiteLocation(siteLocation.getSiteLocationID());
        if(toDelete != null) {
            this.siteLocations.remove(toDelete);
            return create(siteLocation);
        }
        return null;
    }


    public Set<SiteLocation> getAll(){
        return this.siteLocations;
    }
}