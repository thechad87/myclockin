package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.AccessTypes.Date;
import com.chadmarthinussen.domain.TimeAndDateStamp.DateTracker;
import com.chadmarthinussen.factory.DateFactory;
import com.chadmarthinussen.factory.DateTrackerFactory;
import com.chadmarthinussen.services.DateTrackerService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DateTrackerServiceImplTest {


    private static DateTrackerService dateTrackerService;
    private static DateTracker dateTracker;
    private static Date date;

    @BeforeClass
    public static void setUp() {
        date = DateFactory.buildDate("dat-23-43-1990", "01" , "12", "1990");
        dateTrackerService = DateTrackerServiceImpl.getService();
        dateTracker = DateTrackerFactory.buildDateTracker("dat-43-3", "11-13-23" , date);
        dateTrackerService.create(dateTracker);
    }

    @Test
    public void getAddressService() {
        Assert.assertNotNull(dateTrackerService);
    }

    @Test
    public void create() {
        date = DateFactory.buildDate("dat-23-43-1990", "01" , "12", "1990");
        DateTracker newAddress = dateTrackerService.create(DateTrackerFactory.buildDateTracker(
                "dat-43-3", "11-13-23" , date));
        Assert.assertNotNull(newAddress);
        Assert.assertSame(newAddress, dateTrackerService.read(newAddress.getDatetrackerID()));
    }

    @Test
    public void read() {
        DateTracker readDateTracker = dateTrackerService.create(DateTrackerFactory.buildDateTracker(
                "dat-43-3", "11-13-23" , date));
        Assert.assertSame(readDateTracker, dateTrackerService.read(readDateTracker.getDatetrackerID()));
    }

    @Test
    public void update() {
        String newTrackerID = "D123";
        DateTracker dateTrackerTemp = new DateTracker.Builder().copy(dateTracker).dateTrackerID(newTrackerID).build();
        Assert.assertSame(newTrackerID, dateTrackerTemp.getDatetrackerID());
    }

    @Test
    public void delete() {
        DateTracker deleteDateTracker = dateTrackerService.getAll().stream().findFirst().orElse(null);
        int size = dateTrackerService.getAll().size();
        assert deleteDateTracker != null;
        dateTrackerService.delete(deleteDateTracker.getDatetrackerID());
        Assert.assertEquals(size - 1, dateTrackerService.getAll().size());
    }
}