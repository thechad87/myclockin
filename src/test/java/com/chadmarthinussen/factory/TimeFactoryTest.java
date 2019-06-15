package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.UserlType.Contractor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */
public class TimeFactoryTest {
    @Test
    public void getTime() throws Exception {


        boolean isContractor = true;
        int timePeriod = 8;
        String contractorID = "W23456";
        Contractor One = ContractorFactory.getContractor(isContractor, timePeriod, contractorID);
        System.out.println(One);
        Assert.assertEquals( timePeriod, One.getTimePeriodMonths());


    }

}

//    private int seconds;
//    private int minutes;
//    private int hours;