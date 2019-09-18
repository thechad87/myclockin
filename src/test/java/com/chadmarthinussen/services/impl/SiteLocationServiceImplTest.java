package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.Location.SiteLocation;
import com.chadmarthinussen.factory.SiteLocationFactory;
import com.chadmarthinussen.services.SiteLocationService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SiteLocationServiceImplTest {

    private static SiteLocationService siteLocationService;
    private static SiteLocation siteLocation;

    @BeforeClass
    public static void setUp() {
        siteLocationService = SiteLocationServiceImpl.getSiteLocoationService();
        siteLocation = SiteLocationFactory.buildSiteLocation("l123", "2", "woodfern",
                "franschhoek", "cape town", "8000");
        siteLocationService.create(siteLocation);
    }

    @Test
    public void getAddressService() {
        Assert.assertNotNull(siteLocationService);
    }

    @Test
    public void create() {
        SiteLocation siteLocation = siteLocationService.create(SiteLocationFactory.buildSiteLocation(
                "L123", "3", "4th avenue", "stellenbosch", "cape town", "8000"));
        Assert.assertNotNull(siteLocation);
        Assert.assertSame(siteLocation, siteLocationService.read(siteLocation.getSiteLocationID()));
    }

    @Test
    public void read() {
        SiteLocation readSiteLocation = siteLocationService.create(SiteLocationFactory.buildSiteLocation(
                "L123", "3", "4th avenue", "stellenbosch", "cape town", "8000"));
        Assert.assertSame(readSiteLocation, siteLocationService.read(readSiteLocation.getSiteLocationID()));
    }

    @Test
    public void update() {
        String newSiteLocation = "woodfern";
        SiteLocation SiteLocationTemp = new SiteLocation.Builder().copy(siteLocation).streetNumber(newSiteLocation).build();
        Assert.assertSame(newSiteLocation, SiteLocationTemp.getStreetsName());
    }

    @Test
    public void delete() {
        SiteLocation deleteSiteLocation = siteLocationService.getAll().stream().findFirst().orElse(null);
        int size = siteLocationService.getAll().size();
        assert deleteSiteLocation != null;
        siteLocationService.delete(deleteSiteLocation.getStreetsName());
        Assert.assertEquals(size - 1, siteLocationService.getAll().size());
    }
}