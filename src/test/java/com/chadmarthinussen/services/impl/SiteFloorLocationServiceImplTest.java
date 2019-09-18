package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.Location.SiteFloorLocation;
import com.chadmarthinussen.factory.SiteFloorLocationFactory;
import com.chadmarthinussen.services.SiteFloorLocationService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SiteFloorLocationServiceImplTest {

    private static SiteFloorLocationService siteFloorLocationService;
    private static SiteFloorLocation siteFloorLocation;

    @BeforeClass
    public static void setUp() {
        siteFloorLocationService = SiteFloorLocationServiceImpl.getService();
        siteFloorLocation = SiteFloorLocationFactory.buildSiteFloorLocation("Lf10", "district 6",
                "5", "main");
        siteFloorLocationService.create(siteFloorLocation);
    }

    @Test
    public void getAddressService() {
        Assert.assertNotNull(siteFloorLocationService);
    }

    @Test
    public void create() {
        SiteFloorLocation newAddress = siteFloorLocationService.create(SiteFloorLocationFactory.buildSiteFloorLocation(
                "Lf10", "district 6",
                "5", "main"));
        Assert.assertNotNull(newAddress);
        Assert.assertSame(newAddress, siteFloorLocationService.read(newAddress.getBuildingLocation()));
    }

    @Test
    public void read() {
        SiteFloorLocation readTestAddress = siteFloorLocationService.create(SiteFloorLocationFactory.buildSiteFloorLocation("Lf10", "district 6",
                "5", "main"));
        Assert.assertSame(readTestAddress, siteFloorLocationService.read(readTestAddress.getSiteFloorLocationID()));
    }

    @Test
    public void update() {
        String newSiteFloorLocationID = "Fl345";
        SiteFloorLocation siteFloorLocationTemp = new SiteFloorLocation.Builder().copy(siteFloorLocation).siteFloorLocationID(newSiteFloorLocationID).build();
        Assert.assertSame(newSiteFloorLocationID, siteFloorLocationTemp.getSiteFloorLocationID());
    }

    @Test
    public void delete() {
        SiteFloorLocation deleteSiteFloorLocation = siteFloorLocationService.getAll().stream().findFirst().orElse(null);
        int size = siteFloorLocationService.getAll().size();
        assert deleteSiteFloorLocation != null;
        siteFloorLocationService.delete(deleteSiteFloorLocation.getSiteFloorLocationID());
        Assert.assertEquals(size - 1, siteFloorLocationService.getAll().size());
    }
}