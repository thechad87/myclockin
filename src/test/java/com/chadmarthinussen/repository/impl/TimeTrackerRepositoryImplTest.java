package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.TimeAndDateStamp.TimeTracker;
import com.chadmarthinussen.factory.TimeTrackerFactory;
import com.chadmarthinussen.repository.TimeTrackerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TimeTrackerRepositoryImplTest {

    private TimeTrackerRepository repository;
    private TimeTracker timeTracker;

    private TimeTracker getSavedTimeTracker() {
        Set<TimeTracker> savedTimeTrackers = this.repository.getAll();
        return savedTimeTrackers.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TimeTrackerRepositoryImpl.getRepository();
        this.timeTracker = TimeTrackerFactory.buildTimeTracker("Test TimeTracker");
    }

    @Test
    public void a_create() {
        TimeTracker created = this.repository.create(this.timeTracker);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.timeTracker);
    }

    @Test
    public void b_read() {
        TimeTracker savedTimeTracker = getSavedTimeTracker();
        System.out.println("In read, timeTrackerID = "+ savedTimeTracker.getTimeTrackerID());
        TimeTracker read = this.repository.read(savedTimeTracker.getTimeTrackerID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedTimeTracker, read);
    }

    @Test
    public void e_delete() {
        TimeTracker savedTimeTracker = getSavedTimeTracker();
        this.repository.delete(savedTimeTracker.getTimeTrackerID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test TimeTracker Name";
        TimeTracker timeTracker = new TimeTracker.Builder().copy(getSavedTimeTracker()).timeTrackerName(newname).build();
        System.out.println("In update, about_to_updated = " + timeTracker);
        TimeTracker updated = this.repository.update(timeTracker);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getTimeTrackerName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<TimeTracker> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}