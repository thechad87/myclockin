package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.AccessTypes.Time;
import com.chadmarthinussen.factory.TimeFactory;
import com.chadmarthinussen.services.TimeService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TimeServiceImplTest {

    private static TimeService timeService;
    private static Time time;

    @BeforeClass
    public static void setUp() {
        time = TimeFactory.buildTime("T123", "54" , "34", "7");
        timeService = TimeServiceImpl.getService();
        timeService.create(time);
    }

    @Test
    public void getTurnStileAccessService() {
        Assert.assertNotNull(timeService);
    }

    @Test
    public void create() {
        time = TimeFactory.buildTime("T123", "54" , "34", "7");
        Time newTime = timeService.create(time);
        Assert.assertNotNull(newTime);
        Assert.assertSame(newTime, timeService.read(newTime.getTimeID()));
    }

    @Test
    public void read() {
        Time readTime = timeService.create(TimeFactory.buildTime("T123", "54" , "34", "7"));
        Assert.assertSame(readTime, timeService.read(time.getHours()));
    }

    @Test
    public void update() {
        String newTimeID = "A134";
        Time timeTemp = new Time.Builder().copy(time).timeID(newTimeID).build();
        Assert.assertSame(newTimeID, timeTemp.getHours());
    }

    @Test
    public void delete() {
        Time deleteTime = timeService.getAll().stream().findFirst().orElse(null);
        int size = timeService.getAll().size();
        assert deleteTime != null;
        timeService.delete(deleteTime.getTimeID());
        Assert.assertEquals(size - 1, timeService.getAll().size());
    }
}