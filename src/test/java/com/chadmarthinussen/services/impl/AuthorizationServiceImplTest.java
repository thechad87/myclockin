package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.AccessTypes.Authorization;
import com.chadmarthinussen.factory.AuthorizationFactory;
import com.chadmarthinussen.repository.AuthorizationRepository;
import com.chadmarthinussen.repository.impl.AuthorizationRepositoryImpl;
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
public class AuthorizationServiceImplTest {

    private static AuthorizationRepository service;
    private static Authorization authorization;

    private Authorization getSaved() {
        return this.service.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = AuthorizationRepositoryImpl.getRepository();
        this.authorization = AuthorizationFactory.buildAuthorization("9293747", true);
    }

    @Test
    public void a_create() {
        Authorization created = this.service.create(this.authorization);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.authorization);
    }

    @Test
    public void c_update() {
        String newAuthorizationID = "password";
        Authorization authoTemp = new Authorization.Builder().copy(authorization).userTypeID(newAuthorizationID).build();
        Assert.assertSame(newAuthorizationID, authoTemp.getUserTypeID());
    }

    @Test
    public void e_delete() {
        Authorization saved = getSaved();
        this.service.delete(saved.getUserTypeID());
        d_getAll();
    }

    @Test
    public void b_read() {
        Authorization saved = getSaved();
        Authorization read = this.service.read(saved.getUserTypeID());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set <Authorization> authorization = this.service.getAll();
        System.out.println("In getall, all = " + authorization);
    }
}

//    @Test
//    public void a_create() {
//        Administrator created = this.repository.create(this.administrator);
//        System.out.println("In create, created = " + created);
//        Assert.assertNotNull(created);
//        Assert.assertSame(created, this.administrator);
//    }
//
//    @Test
//    public void c_update() {
//        String Admin = "Ralph";
//        Administrator AdminTemp = new Administrator.Builder().copy(administrator).administratorID(Admin).build();
//        Assert.assertSame(Admin, AdminTemp.getAdministratorID());
//    }
//
//    @Test
//    public void e_delete() {
//        Administrator saved = getSaved();
//        this.repository.delete(saved.getAdministratorID());
//        d_getAll();
//    }


