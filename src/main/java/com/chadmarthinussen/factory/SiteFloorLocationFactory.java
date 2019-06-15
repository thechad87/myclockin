package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.Location.SiteFloorLocation;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class SiteFloorLocationFactory {

    public static SiteFloorLocation buildBuildingFloorLocation(String siteFloorLocationID, String buildingLocation, String floorNumber, String siteFloorLocationEntrance){
    return new SiteFloorLocation.Builder().siteFloorLocationID(siteFloorLocationID).siteFloorLocationID(siteFloorLocationID).buildingLocation(buildingLocation).floorNumber(floorNumber).siteFloorLocationEntrance(siteFloorLocationEntrance).build();
    }
}

