package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.UserlType.Guest;
import com.chadmarthinussen.factory.GuestFactory;
import com.chadmarthinussen.services.GuestService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GuestServiceImplTest {


    private static GuestService guestService;
    private static Guest guest;

    @BeforeClass
    public static void setUp() {
        guestService = GuestServiceImpl.getService();
        guest = GuestFactory.buildGuest(
                "amazon", "Gu224", "luke skywalker", "082765670");
        guestService.create(guest);
    }

    @Test
    public void getAddressService()
    {
        Assert.assertNotNull(guestService);
    }

    @Test
    public void create() {
        Guest newGuest = guestService.create(GuestFactory.buildGuest(
                "amazon", "Gu224", "luke skywalker", "082765670"));
        Assert.assertNotNull(newGuest);
        Assert.assertSame(newGuest, guestService.read(newGuest.getGuestAssignedID()));
    }

    @Test
    public void read() {
        Guest readGuest = guestService.create(GuestFactory.buildGuest(
                "amazon", "Gu224", "luke skywalker", "082765670"));
        Assert.assertSame(readGuest, guestService.read(readGuest.getGuestAssignedID()));
    }

    @Test
    public void update() {
        String newGuest = "Ralph";
        Guest guestTemp = new Guest.Builder().copy(guest).guestAssignedID(newGuest).build();
        Assert.assertSame(newGuest, guestTemp.getGuestAssignedID());
    }

    @Test
    public void delete() {
        Guest deleteGuest = guestService.getAll().stream().findFirst().orElse(null);
        int size = guestService.getAll().size();
        assert deleteGuest != null;
        guestService.delete(deleteGuest.getGuestAssignedID());
        Assert.assertEquals(size - 1, guestService.getAll().size());
    }
}