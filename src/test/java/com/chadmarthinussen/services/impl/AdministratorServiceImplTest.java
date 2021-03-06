package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.UserlType.Administrator;
import com.chadmarthinussen.factory.AdministratorFactory;
import com.chadmarthinussen.repository.impl.AdministratorRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministratorServiceImplTest {

    @Qualifier("AdministratorServiceImp")
    private AdministratorRepositoryImpl repository;
    private Administrator administrator;

    private Administrator getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AdministratorRepositoryImpl.getRepository();
        this.administrator = AdministratorFactory.buildAdministrator("9293747", true, true);
    }

    @Test
    public void a_create() {
        Administrator created = this.repository.create(this.administrator);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.administrator);
    }

    @Test
    public void c_update() {
        String Admin = "Ralph";
        Administrator AdminTemp = new Administrator.Builder().copy(administrator).administratorID(Admin).build();
        Assert.assertSame(Admin, AdminTemp.getAdministratorID());
    }

    @Test
    public void e_delete() {
        Administrator saved = getSaved();
        this.repository.delete(saved.getAdministratorID());
        d_getAll();
    }

    @Test
    public void b_read() {
        Administrator saved = getSaved();
        Administrator read = this.repository.read(saved.getAdministratorID());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Administrator> administrators = this.repository.getAll();
        System.out.println("In getall, all = " + administrators);
    }
}