package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.AccessTypes.Date;
import com.chadmarthinussen.factory.DateFactory;
import com.chadmarthinussen.repository.DateRepository;
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
public class DateRepositoryImplTest {

    private DateRepository repository;
    private Date date;

    private Date getSavedDate() {
        Set<Date> savedDates = this.repository.getAll();
        return savedDates.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = DateRepositoryImpl.getRepository();
        this.date = DateFactory.buildDate("Test Date", "01", "12", "1998");
    }

    @Test
    public void a_create() {
        Date created = this.repository.create(this.date);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.date);
    }

    @Test
    public void b_read() {
        Date savedDate = getSavedDate();
        System.out.println("In read, dateID = "+ savedDate.getDateID());
        Date read = this.repository.read(savedDate.getDateID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedDate, read);
    }

    @Test
    public void e_delete() {
        Date savedDate = getSavedDate();
        this.repository.delete(savedDate.getDateID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String testD = "Test_Date";
        Date date = new Date.Builder().copy(getSavedDate()).dateID(testD).build();
        System.out.println("In update, about_to_updated = " + date);
        Date updated = this.repository.update(date);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(testD, updated.getDateID());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Date> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}