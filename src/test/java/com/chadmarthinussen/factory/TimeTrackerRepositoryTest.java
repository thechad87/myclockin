package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.AccessTypes.Time;
import com.chadmarthinussen.domain.TimeAndDateStamp.TimeTracker;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */
public class TimeTrackerRepositoryTest {

    //creating the test for checkinTime, checkoutTime and if the employee's already checked in
    @Test
    public void getTimeTracker() throws Exception {


        boolean isContractor = true;
        Time timeIn = TimeFactory.buildTime("T23", "30", "24", "5");
        Time timeOut = TimeFactory.buildTime("T24", "45", "14", "12");
        TimeTracker One = TimeTrackerFactory.buildTimeTracker("D123", timeIn, timeOut, true);
        System.out.println(One);
        Assert.assertEquals( "", One.getTimeTrackerID());


    }

}
