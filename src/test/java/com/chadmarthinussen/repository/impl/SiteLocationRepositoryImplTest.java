package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.Location.SiteLocation;
import com.chadmarthinussen.factory.SiteLocationFactory;
import com.chadmarthinussen.repository.SiteLocationRepository;
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
public class SiteLocationRepositoryImplTest {

    private SiteLocationRepository repository;
    private SiteLocation siteLocation;

    private SiteLocation getSavedSiteLocation() {
        Set<SiteLocation> savedSiteLocations = this.repository.getAll();
        return savedSiteLocations.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SiteLocationRepositoryImpl.getRepository();
        this.siteLocation = SiteLocationFactory
                .buildSiteLocation("Test SiteLocation", "2"
                        , "4th ave", "stellenbosch", "cape town", "5000");
    }

    @Test
    public void a_create() {
        SiteLocation created = this.repository.create(this.siteLocation);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.siteLocation);
    }

    @Test
    public void b_read() {
        SiteLocation savedSiteLocation = getSavedSiteLocation();
        System.out.println("In read, siteLocationID = "+ savedSiteLocation.getSiteLocationID());
        SiteLocation read = this.repository.read(savedSiteLocation.getSiteLocationID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSiteLocation, read);
    }

    @Test
    public void e_delete() {
        SiteLocation savedSiteLocation = getSavedSiteLocation();
        this.repository.delete(savedSiteLocation.getSiteLocationID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test SiteLocation Name";
        SiteLocation siteLocation = new SiteLocation.Builder().copy(getSavedSiteLocation()).sitelocationID(newname).build();
        System.out.println("In update, about_to_updated = " + siteLocation);
        SiteLocation updated = this.repository.update(siteLocation);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getSiteLocationID());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<SiteLocation> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}