package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.AccessTypes.PasswordCredential;
import com.chadmarthinussen.repository.PasswordCredentialRepository;
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
public class PasswordCredentialRepositoryImplTest {

    private PasswordCredentialRepository repository;
    private PasswordCredential passwordCredential;

    private PasswordCredential getSavedPasswordCredential() {
        Set<PasswordCredential> savedPasswordCredentials = this.repository.getAll();
        return savedPasswordCredentials.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = PasswordCredentialRepositoryImpl.getRepository();
        this.passwordCredential = PasswordCredentialFactory.buildPasswordCredential("Test PasswordCredential");
    }

    @Test
    public void a_create() {
        PasswordCredential created = this.repository.create(this.passwordCredential);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.passwordCredential);
    }

    @Test
    public void b_read() {
        PasswordCredential savedPasswordCredential = getSavedPasswordCredential();
        System.out.println("In read, passwordCredentialID = "+ savedPasswordCredential.getPasswordCredentialID());
        PasswordCredential read = this.repository.read(savedPasswordCredential.getPasswordCredentialID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedPasswordCredential, read);
    }

    @Test
    public void e_delete() {
        PasswordCredential savedPasswordCredential = getSavedPasswordCredential();
        this.repository.delete(savedPasswordCredential.getPasswordCredentialID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test PasswordCredential Name";
        PasswordCredential passwordCredential = new PasswordCredential.Builder().copy(getSavedPasswordCredential()).passwordCredentialName(newname).build();
        System.out.println("In update, about_to_updated = " + passwordCredential);
        PasswordCredential updated = this.repository.update(passwordCredential);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getPasswordCredentialName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<PasswordCredential> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}