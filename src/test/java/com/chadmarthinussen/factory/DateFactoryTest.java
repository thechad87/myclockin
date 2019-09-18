package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.AccessTypes.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */
public class DateFactoryTest {
    @Test
    public void getDate() throws Exception {
        //create the test for the date class

        String dateID = "D234";
        String day = "01";
        String month = "02";
        String year = "1992";
        Date One = DateFactory.buildDate(dateID, day, month , year);
        System.out.println(One);
        Assert.assertEquals( year, One.getMonth());

    }

}

