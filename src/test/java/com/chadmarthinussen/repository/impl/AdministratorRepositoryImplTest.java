package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.UserlType.Administrator;
import com.chadmarthinussen.factory.AdministratorFactory;
import com.chadmarthinussen.repository.AdministratorRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/05/01.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministratorRepositoryImplTest {

    private AdministratorRepository repository;
    private Administrator administrator;


    private Administrator getSavedAdministrator() {
        Set<Administrator> savedAdministrators = this.repository.getAll();
        return savedAdministrators.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AdministratorRepositoryImpl.getRepository();
        this.administrator = AdministratorFactory.buildAdministrator("E991274", true, true);
    }

    @Test
    public void a_create() {
        Administrator created = this.repository.create(this.administrator);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.administrator);
    }

    @Test
    public void b_read() {
        Administrator savedAdministrator = getSavedAdministrator();
        System.out.println("In read, administratorID = "+ savedAdministrator.getAdministratorID());
        Administrator read = this.repository.read(savedAdministrator.getAdministratorID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedAdministrator, read);
    }

    @Test
    public void e_delete() {
        Administrator savedAdministrator = getSavedAdministrator();
        this.repository.delete(savedAdministrator.getAdministratorID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String Admin = "Administrator";
        Administrator administrator =  new Administrator.Builder().copy(getSavedAdministrator()).administratorID(Admin).build();
        System.out.println("In update, about_to_updated = " + administrator);
        Administrator updated = this.repository.update(administrator);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(Admin, true);
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Administrator> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(1, all.size());
    }
}
