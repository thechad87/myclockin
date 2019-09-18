package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.UserlType.Contractor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class ContractorRepositoryImplTest {

    @Test
    public void getContractor(){

        boolean isContractor = true;
        String  timePeriod = "8";
        String contractorID = "23456";
        Contractor One = ContractorFactory.buildContractor( isContractor, timePeriod, contractorID);
        System.out.println(One);
        Assert.assertEquals( timePeriod, One.getTimePeriodMonths());
    }

}

//    private boolean isContactor;
//    private String timePeriod;
//    private String contractorID;