package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.UserlType.Contractor;
import com.chadmarthinussen.factory.ContractorFactory;
import com.chadmarthinussen.repository.ContractorRepository;
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
public class ContractorRepositoryImplTest {

    private ContractorRepository repository;
    private Contractor contractor;

    private Contractor getSavedContractor() {
        Set<Contractor> savedContractors = this.repository.getAll();
        return savedContractors.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ContractorRepositoryImpl.getRepository();
        this.contractor = ContractorFactory.buildContractor(true , "3432487", "ID123");
    }

    @Test
    public void a_create() {
        Contractor created = this.repository.create(this.contractor);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.contractor);
    }

    @Test
    public void b_read() {
        Contractor savedContractor = getSavedContractor();
        System.out.println("In read, contractorID = "+ savedContractor.getContractorID());
        Contractor read = this.repository.read(savedContractor.getContractorID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedContractor, read);
    }

    @Test
    public void e_delete() {
        Contractor savedContractor = getSavedContractor();
        this.repository.delete(savedContractor.getContractorID());
        d_getAll();
    }

    @Test
    public void c_update() {
        String Contr = "ID11";
        Contractor contractor = new Contractor.Builder().copy(getSavedContractor()).contractorID(Contr).build();
        System.out.println("In update, about_to_updated = " + contractor);
        Contractor updated = this.repository.update(contractor);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(Contr, updated.getContractorID());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Contractor> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}