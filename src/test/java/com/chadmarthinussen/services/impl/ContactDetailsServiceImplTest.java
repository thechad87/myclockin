package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.PersonalDetails.ContactDetails;
import com.chadmarthinussen.factory.ContactDetailsFactory;
import com.chadmarthinussen.repository.impl.ContactDetailsRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactDetailsServiceImplTest {

    @Autowired
    private ContactDetailsRepositoryImpl services;
    private ContactDetails contactDetails;

    private ContactDetails getSaved(){
        return this.services.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.services = ContactDetailsRepositoryImpl.getRepository();
        this.contactDetails = ContactDetailsFactory
        .buildContactDetails("A123", "1234567", "0213456", "joe@gmail");
    }

    @Test
    public void create() {
        ContactDetails created = this.services.create(this.contactDetails);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.contactDetails);
    }

//    contactDetailsName(newContactDetailsName).build()
    @Test
    public void update() {

        String contactDetailID = "02134565";
        ContactDetails contactDetsForm = new ContactDetails.Builder().copy(contactDetails).contactDetailsID(contactDetailID).build();
        services.create(contactDetsForm);
        Assert.assertSame(contactDetailID, services.read(contactDetsForm.getContactDetailsID()));
    }


    @Test
    public void delete() {
        ContactDetails saved = getSaved();
        this.services.delete(saved.getContactDetailsID());
        getAll();
    }

    @Test
    public void read() {
        ContactDetails saved = getSaved();
        ContactDetails read = this.services.read(saved.getContactDetailsID());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read, saved);
    }

    @Test
    public void getAll() {
        Set<ContactDetails> contactDetailss = this.services.getAll();
        System.out.println("In getall, all = " + contactDetailss);
    }
}