package com.chadmarthinussen.repository;

import com.chadmarthinussen.domain.Location.SiteLocation;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public interface SiteLocationRepository extends IRepository<SiteLocation,String> {
    Set <SiteLocation> getAll();
}
