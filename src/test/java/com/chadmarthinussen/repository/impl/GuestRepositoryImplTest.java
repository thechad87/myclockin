package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.UserlType.Guest;
import com.chadmarthinussen.factory.GuestFactory;
import com.chadmarthinussen.repository.GuestRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GuestRepositoryImplTest {

    private GuestRepository repository;
    private Guest guest;

    private Guest getSavedGuest() {
        Set<Guest> savedGuests = this.repository.getAll();
        return savedGuests.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = GuestRepositoryImpl.getRepository();
        this.guest = GuestFactory.buildGuest("Woolworths", "12345", "chad mart", "021 578987");
    }

    @Test
    public void a_create() {
        Guest created = this.repository.create(this.guest);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.guest);
    }

    @Test
    public void b_read() {
        Guest savedGuest = getSavedGuest();
        System.out.println("In read, guestID = "+ savedGuest.getGuestAssignedID());
        Guest read = this.repository.read(savedGuest.getGuestAssignedID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedGuest, read);
    }

    @Test
    public void e_delete() {
        Guest savedGuest = getSavedGuest();
        this.repository.delete(savedGuest.getGuestAssignedID());
        d_getAll();
    }
    @Test
    public void c_update() {
        String newname = "New Date";
        System.out.println("In update, about_to_updated = " + guest);
        Guest updated = this.repository.update(guest);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getFullName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Guest> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}