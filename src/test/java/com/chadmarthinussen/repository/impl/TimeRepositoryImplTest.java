package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.AccessTypes.Time;
import com.chadmarthinussen.factory.TimeFactory;
import com.chadmarthinussen.repository.TimeRepository;
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
public class TimeRepositoryImplTest {

    private TimeRepository repository;
    private Time time;

    private Time getSavedTime() {
        Set<Time> savedTimes = this.repository.getAll();
        return savedTimes.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TimeRepositoryImpl.getRepository();
        this.time = TimeFactory.buildTime("Test Time");
    }

    @Test
    public void a_create() {
        Time created = this.repository.create(this.time);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.time);
    }

    @Test
    public void b_read() {
        Time savedTime = getSavedTime();
        System.out.println("In read, timeID = "+ savedTime.getTimeID());
        Time read = this.repository.read(savedTime.getTimeID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedTime, read);
    }

    @Test
    public void e_delete() {
        Time savedTime = getSavedTime();
        this.repository.delete(savedTime.getTimeID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Time Name";
        Time time = new Time.Builder().copy(getSavedTime()).timeName(newname).build();
        System.out.println("In update, about_to_updated = " + time);
        Time updated = this.repository.update(time);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getTimeName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Time> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}