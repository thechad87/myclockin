package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.PersonalDetails.Name;
import com.chadmarthinussen.Domain.UserlType.Staff;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/10.
 * student number : 208031197
 *
 */
public class StaffFactoryTest {

    @Test
    public void getStaff(){

        String surname = "marty";
        long staffID = 124567890;
        Staff One = StaffFactory.getStaff( new Name("chad", "mart", "marty"), "");
        System.out.println(One);
        Assert.assertEquals( staffID, One.getStaffID());
    }
}