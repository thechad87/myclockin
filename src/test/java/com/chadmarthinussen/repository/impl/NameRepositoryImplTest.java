package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.PersonalDetails.Name;
import com.chadmarthinussen.factory.NameFactory;
import com.chadmarthinussen.repository.NameRepository;
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
public class NameRepositoryImplTest {

    private NameRepository repository;
    private Name name;

    private Name getSavedName() {
        Set<Name> savedNames = this.repository.getAll();
        return savedNames.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = NameRepositoryImpl.getRepository();
        this.name = NameFactory.buildName("Test Name");
    }

    @Test
    public void a_create() {
        Name created = this.repository.create(this.name);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.name);
    }

    @Test
    public void b_read() {
        Name savedName = getSavedName();
        System.out.println("In read, nameID = "+ savedName.getNameID());
        Name read = this.repository.read(savedName.getNameID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedName, read);
    }

    @Test
    public void e_delete() {
        Name savedName = getSavedName();
        this.repository.delete(savedName.getNameID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Name Name";
        Name name = new Name.Builder().copy(getSavedName()).nameName(newname).build();
        System.out.println("In update, about_to_updated = " + name);
        Name updated = this.repository.update(name);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getNameName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Name> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}