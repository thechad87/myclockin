package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.UserlType.Contractor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class ContractorRepositoryImplTest {

    @Test
    public void getContractor(){

        boolean isContractor = true;
        int timePeriod = 8;
        int contractorID = 23456;
        Contractor One = ContractorFactory.getContractor(isContractor, timePeriod, contractorID);
        System.out.println(One);
        Assert.assertEquals( timePeriod, One.getTimePeriodMonths());
    }

}

//    private boolean isContactor;
//    private String timePeriod;
//    private String contractorID;