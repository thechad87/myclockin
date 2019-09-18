package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.AccessTypes.Authorization;
import com.chadmarthinussen.factory.AuthorizationFactory;
import com.chadmarthinussen.repository.AuthorizationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */


@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationRepositoryImplTest {

    private AuthorizationRepository repository;
    private Authorization authorization;

    private Authorization getSavedAuthorization() {
        Set<Authorization> savedAuthorizations = this.repository.getAll();
        return savedAuthorizations.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AuthorizationRepositoryImpl.getRepository();
        this.authorization = AuthorizationFactory.buildAuthorization(" W342348", true);
    }

    @Test
    public void a_create() {
        Authorization created = this.repository.create(this.authorization);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.authorization);
    }

    @Test
    public void b_read() {
        Authorization savedAuthorization = getSavedAuthorization();
        System.out.println("In read, authorizationID = "+ savedAuthorization.getUserTypeID());
        Authorization read = this.repository.read(savedAuthorization.getUserTypeID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedAuthorization, read);
    }

    @Test
    public void e_delete() {
        Authorization savedAuthorization = getSavedAuthorization();
        this.repository.delete(savedAuthorization.getUserTypeID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String Admin = "New Test Authorization";
        Authorization authorization = new Authorization.Builder().copy(getSavedAuthorization()).userTypeID(Admin).build();
        System.out.println("In update, about_to_updated = " + authorization);
        Authorization updated = this.repository.update(authorization);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(Admin, updated.getUserTypeID());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Authorization> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}