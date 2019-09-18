package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.Location.SiteFloorLocation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class SiteFloorLocationFactoryTest {

    @Test
    public void getBuildingFloorLocation(){

        String siteFloor = "Engineering Building";
        String buildingLoc = "Engineering Building";
        String floorNumber = "Engineering Building";
        String entrance = "Engineering Building";
        SiteFloorLocation One = SiteFloorLocationFactory.buildSiteFloorLocation(siteFloor, buildingLoc, floorNumber, entrance);
        System.out.println(One);
        Assert.assertEquals( buildingLoc, One.getBuildingLocation());
    }

}

//    private String buildingLocation;
//    private String floorNumber;
