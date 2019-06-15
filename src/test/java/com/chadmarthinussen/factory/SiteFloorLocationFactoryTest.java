package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.Location.SiteFloorLocation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class SiteFloorLocationFactoryTest {

    @Test
    public void getBuildingFloorLocation(){

        String buildingLoc = "Engineering Building";
        int floorNum = 1;
        SiteFloorLocation One = SiteFloorLocationFactory.getBuildingFloorLocation(buildingLoc, floorNum);
        System.out.println(One);
        Assert.assertEquals( buildingLoc, One.getBuildingLocation());
    }

}

//    private String buildingLocation;
//    private String floorNumber;
