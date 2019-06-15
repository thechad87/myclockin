package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.Domain.PersonalDetails.ContactDetails;
import com.chadmarthinussen.factory.ContactDetailsFactory;
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
public class ContactDetailsServiceImplTest {

    private ContactDetailsServicesImpl services;
    private ContactDetails contactDetails;

    private ContactDetails getSaved(){
        return this.services.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.services = ContactDetailsServicesImpl.getServices();
        this.contactDetails = ContactDetailsFactory.buildContactDetails("Application Development Practice 3");
    }

    @Test
    public void a_create() {
        ContactDetails created = this.services.create(this.contactDetails);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.contactDetails);
    }

    @Test
    public void c_update() {
        String newContactDetailsName = "Application Development Theory 3";
        ContactDetails updated = new ContactDetails.Builder().copy(getSaved()).contactDetailsName(newContactDetailsName).build();
        System.out.println("In update, updated = " + updated);
        this.services.update(updated);
        Assert.assertSame(newContactDetailsName, updated.getContactDetailsName());
    }

    @Test
    public void e_delete() {
        ContactDetails saved = getSaved();
        this.services.delete(saved.getContactDetailsId());
        d_getAll();
    }

    @Test
    public void b_read() {
        ContactDetails saved = getSaved();
        ContactDetails read = this.services.read(saved.getContactDetailsId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<ContactDetails> contactDetailss = this.services.getAll();
        System.out.println("In getall, all = " + contactDetailss);
    }
}