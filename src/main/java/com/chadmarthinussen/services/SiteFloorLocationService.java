package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.Location.SiteFloorLocation;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface SiteFloorLocationService extends IService<SiteFloorLocation, String> {
        Set<SiteFloorLocation> getAll();
}
