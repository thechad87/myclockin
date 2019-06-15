package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.UserlType.Intern;
import com.chadmarthinussen.factory.InternFactory;
import com.chadmarthinussen.repository.InternRepository;
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
public class InternRepositoryImplTest {

    private InternRepository repository;
    private Intern intern;

    private Intern getSavedIntern() {
        Set<Intern> savedInterns = this.repository.getAll();
        return savedInterns.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = InternRepositoryImpl.getRepository();
        this.intern = InternFactory.buildIntern("Test Intern");
    }

    @Test
    public void a_create() {
        Intern created = this.repository.create(this.intern);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.intern);
    }

    @Test
    public void b_read() {
        Intern savedIntern = getSavedIntern();
        System.out.println("In read, internID = "+ savedIntern.getInternID());
        Intern read = this.repository.read(savedIntern.getInternID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedIntern, read);
    }

    @Test
    public void e_delete() {
        Intern savedIntern = getSavedIntern();
        this.repository.delete(savedIntern.getInternID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Intern Name";
        Intern intern = new Intern.Builder().copy(getSavedIntern()).internName(newname).build();
        System.out.println("In update, about_to_updated = " + intern);
        Intern updated = this.repository.update(intern);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getInternName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Intern> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}

//    boolean isContractor = true;
//    int timePeriod = 8;
//    String contractorID = "W23456";
//    Contractor One = ContractorFactory.getContractor(isContractor, timePeriod, contractorID);
//        System.out.println(One);
//                Assert.assertEquals( timePeriod, One.getTimePeriodMonths());
