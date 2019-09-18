package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.PersonalDetails.Name;
import com.chadmarthinussen.domain.UserlType.Staff;
import com.chadmarthinussen.factory.NameFactory;
import com.chadmarthinussen.factory.StaffFactory;
import com.chadmarthinussen.services.StaffService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StaffServiceImplTest {

    private static StaffService staffService;
    private static Staff staff;
    private static Name name;

    @BeforeClass
    public static void setUp() {
        Name name = NameFactory.buildName("12345", "joe" , "james" ,"soap");
        staffService = StaffServiceImpl.getService();
        staff = StaffFactory.buildStaff(name , "W24556");
        staffService.create(staff);
    }

    @Test
    public void getAddressService() {
        Assert.assertNotNull(staffService);
    }

    @Test
    public void create() {
        name = NameFactory.buildName("I134", "joe", "james", "rogan");
        Staff newStaff = staffService.create(StaffFactory.buildStaff(name, "W12345"));
        Assert.assertNotNull(newStaff);
        Assert.assertSame(newStaff, staffService.read(newStaff.getStaffID()));
    }

    @Test
    public void read() {
        Name name = NameFactory.buildName("12345", "joe" , "james" ,"soap");
        Staff readStaff = staffService.create(StaffFactory.buildStaff(name , "W24556"));
        Assert.assertSame(readStaff, staffService.read(readStaff.getStaffID()));
    }

    @Test
    public void update() {
        String newStaff = "W123";
        Staff staffTemp = new Staff.Builder().copy(staff).staffID(newStaff).build();
        Assert.assertSame(newStaff, staffTemp.getStaffID());
    }

    @Test
    public void delete() {
        Staff deleteStaff = staffService.getAll().stream().findFirst().orElse(null);
        int size = staffService.getAll().size();
        assert deleteStaff != null;
        staffService.delete(deleteStaff.getStaffID());
        Assert.assertEquals(size - 1, staffService.getAll().size());
    }
}