package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.AccessTypes.Date;
import com.chadmarthinussen.domain.TimeAndDateStamp.DateTracker;
import com.chadmarthinussen.factory.DateFactory;
import com.chadmarthinussen.factory.DateTrackerFactory;
import com.chadmarthinussen.repository.DateTrackerRepository;
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
public class DateTrackerRepositoryImplTest {

    private DateTrackerRepository repository;
    private DateTracker dateTracker;
    private Date date;

    private DateTracker getSavedDateTracker() {
        Set<DateTracker> savedDateTrackers = this.repository.getAll();
        return savedDateTrackers.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        date = DateFactory.buildDate("D1", "01", "3", "2019");
        this.repository = DateTrackerRepositoryImpl.getRepository();
        this.dateTracker = DateTrackerFactory.buildDateTracker("Test DateTracker", "A_01-23-3", date );
    }

    @Test
    public void a_create() {
        DateTracker created = this.repository.create(this.dateTracker);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.dateTracker);
    }

    @Test
    public void b_read() {
        DateTracker savedDateTracker = getSavedDateTracker();
        System.out.println("In read, dateTrackerID = "+ savedDateTracker.getDatetrackerID());
        DateTracker read = this.repository.read(savedDateTracker.getDatetrackerID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedDateTracker, read);
    }

    @Test
    public void e_delete() {
        DateTracker savedDateTracker = getSavedDateTracker();
        this.repository.delete(savedDateTracker.getDatetrackerID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test DateTracker Name";
        DateTracker dateTracker = new DateTracker.Builder().copy(getSavedDateTracker()).dateTrackerID(newname).build();
        System.out.println("In update, about_to_updated = " + dateTracker);
        DateTracker updated = this.repository.update(dateTracker);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getDatetrackerID());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<DateTracker> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}