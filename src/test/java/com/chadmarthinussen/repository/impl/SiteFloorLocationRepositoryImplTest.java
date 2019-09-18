package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.Location.SiteFloorLocation;
import com.chadmarthinussen.factory.SiteFloorLocationFactory;
import com.chadmarthinussen.repository.SiteFloorLocationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SiteFloorLocationRepositoryImplTest {

    private SiteFloorLocationRepository repository;
    private SiteFloorLocation siteFloorLocation;

    private SiteFloorLocation getSavedSiteFloorLocation() {
        Set<SiteFloorLocation> savedSiteFloorLocations = this.repository.getAll();
        return savedSiteFloorLocations.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SiteFloorLocationRepositoryImpl.getRepository();
        this.siteFloorLocation = SiteFloorLocationFactory
                .buildSiteFloorLocation("Test SiteFloorLocation", "foreshore", "3", "lift");
    }

    @Test
    public void a_create() {
        SiteFloorLocation created = this.repository.create(this.siteFloorLocation);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.siteFloorLocation);
    }

    @Test
    public void b_read() {
        SiteFloorLocation savedSiteFloorLocation = getSavedSiteFloorLocation();
        System.out.println("In read, siteFloorLocationID = "+ savedSiteFloorLocation.getSiteFloorLocationID());
        SiteFloorLocation read = this.repository.read(savedSiteFloorLocation.getSiteFloorLocationID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSiteFloorLocation, read);
    }

    @Test
    public void e_delete() {
        SiteFloorLocation savedSiteFloorLocation = getSavedSiteFloorLocation();
        this.repository.delete(savedSiteFloorLocation.getSiteFloorLocationID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test SiteFloorLocation Name";
        SiteFloorLocation siteFloorLocation = new SiteFloorLocation.Builder().copy(getSavedSiteFloorLocation()).siteFloorLocationID(newname).build();
        System.out.println("In update, about_to_updated = " + siteFloorLocation);
        SiteFloorLocation updated = this.repository.update(siteFloorLocation);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getSiteFloorLocationID());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<SiteFloorLocation> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}