package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.PersonalDetails.Name;
import com.chadmarthinussen.domain.UserlType.Staff;
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

        Name name = new NameFactory().buildName("N4353", "bat", "james", "man");
        Staff staff = new StaffFactory().buildStaff(name,"7023422");
        System.out.println(staff);
        Assert.assertEquals( staff,  staff.getStaffID());
    }
}