package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.AccessTypes.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */
public class DateFactoryTest {
    @Test
    public void getDate() throws Exception {
        //create the test for the date class

        int day = 01;
        int month = 02;
        int year = 1992;
        Date One = DateFactory.getDate(day, month, year);
        System.out.println(One);
        Assert.assertEquals( year, One.getMonth());

    }

}


//    private int day;
//    private int month;
//    private int year;