package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.UserlType.Contractor;
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
        int timePeriod = 8;
        String contractorID = "W23456";
        Contractor One = ContractorFactory.getContractor(isContractor, timePeriod, contractorID);
        System.out.println(One);
        Assert.assertEquals( timePeriod, One.getTimePeriodMonths());


    }

}

//    private Time userCheckInTimer;
//    private Time userCheckOutTimer;
//    private boolean isCurrentlyCheckedIn;