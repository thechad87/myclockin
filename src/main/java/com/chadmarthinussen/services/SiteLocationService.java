package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.Location.SiteLocation;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface SiteLocationService extends IService<SiteLocation, String> {
        Set<SiteLocation> getAll();
}
