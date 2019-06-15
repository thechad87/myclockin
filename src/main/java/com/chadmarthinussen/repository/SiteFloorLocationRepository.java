package com.chadmarthinussen.repository;

import com.chadmarthinussen.Domain.Location.SiteFloorLocation;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */

public interface SiteFloorLocationRepository extends IRepository<SiteFloorLocation,String> {
    Set<SiteFloorLocation> getAll();
}
