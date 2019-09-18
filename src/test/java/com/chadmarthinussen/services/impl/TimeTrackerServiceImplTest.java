package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.AccessTypes.Time;
import com.chadmarthinussen.domain.TimeAndDateStamp.TimeTracker;
import com.chadmarthinussen.factory.TimeFactory;
import com.chadmarthinussen.factory.TimeTrackerFactory;
import com.chadmarthinussen.services.TimeTrackerService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TimeTrackerServiceImplTest {

    private static TimeTrackerService timeTrackerService;
    private static TimeTracker timeTracker;

    @BeforeClass
    public static void setUp() {

        Time timeIn = TimeFactory.buildTime("T12", "34", "35", "6");
        Time timeOut = TimeFactory.buildTime("T13", "56", "23", "10");
        TimeTracker timeTrackeSetup = TimeTrackerFactory.buildTimeTracker("T123", timeIn, timeOut , true);
        timeTrackerService = TimeTrackerServiceImpl.getService();
        timeTracker = TimeTrackerFactory.buildTimeTracker( "W123", timeIn, timeOut, true);
        timeTrackerService.create(timeTracker);

    }

    @Test
    public void getTimeTrackerService() {
        Assert.assertNotNull(timeTrackerService);
    }

    @Test
    public void create() {

        Time timeIn = TimeFactory.buildTime("T12", "34", "35", "6");
        Time timeOut = TimeFactory.buildTime("T13", "56", "23", "10");
        TimeTracker newTimeTracker = timeTrackerService.create(TimeTrackerFactory.buildTimeTracker("T12", timeIn, timeOut, true));

        Assert.assertNotNull(newTimeTracker);
        Assert.assertSame(newTimeTracker, timeTrackerService.create(newTimeTracker));
        System.out.println(newTimeTracker);
    }

    @Test
    public void read() {
        Time timeIn = TimeFactory.buildTime("T12", "34", "35", "6");
        Time timeOut = TimeFactory.buildTime("T13", "56", "23", "10");
        TimeTracker timeTracker = TimeTrackerFactory.buildTimeTracker("T12", timeIn , timeOut, true);
        TimeTracker readTurnStileAccess = timeTrackerService.create(timeTracker);
        Assert.assertSame(readTurnStileAccess, timeTrackerService.read(readTurnStileAccess.getTimeTrackerID()));
        System.out.println(timeTracker);

    }

    @Test
    public void update() {
        String newTimeTrackerID = "A134";
        TimeTracker addressTemp = new TimeTracker.Builder().copy(timeTracker).timeTrackerID(newTimeTrackerID).build();
        Assert.assertSame(newTimeTrackerID, addressTemp.getTimeTrackerID());
        System.out.println(addressTemp);

    }

    @Test
    public void delete() {
        TimeTracker deleteTimeTracker = timeTrackerService.getAll().stream().findFirst().orElse(null);
        int size = timeTrackerService.getAll().size();
        assert deleteTimeTracker != null;
        timeTrackerService.delete(deleteTimeTracker.getTimeTrackerID());
        Assert.assertEquals( 1, timeTrackerService.getAll().size());
        System.out.println(deleteTimeTracker);
    }
}