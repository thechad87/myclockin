package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.UserlType.Contractor;
import com.chadmarthinussen.factory.ContractorFactory;
import com.chadmarthinussen.services.ContractorService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContractorServiceImplTest {
    private static ContractorService contractorService;
    private static Contractor contractor;

    @BeforeClass
    public static void setUp() {
        contractorService = ContractorServiceImpl.getService();
        contractor = ContractorFactory.buildContractor(true, "12", "Mder2");
        contractorService.create(contractor);
    }

    @Test
    public void getArtFormService() {
        Assert.assertNotNull(contractorService);
    }

    @Test
    public void create() {
        Contractor contractorCreate = ContractorFactory.buildContractor(true, "12", "Mder2");
        contractorService.create(contractorCreate);
        Assert.assertEquals(contractorCreate, contractorService.read(contractorCreate.getContractorID()));
    }

    @Test
    public void read() {
        Contractor contractRead = contractorService.read(contractor.getContractorID());
        Assert.assertSame(contractRead, contractorService.read(contractRead.getContractorID()));
    }

    @Test
    public void update() {
        String contractorID = contractor.getContractorID();
        Contractor contractorID_2 = new Contractor.Builder().copy(contractor).contractorID(contractorID).build();
        contractorService.create(contractorID_2);
        Assert.assertSame(contractorID, contractorService.read(contractorID_2.getContractorID()));
    }

    @Test
    public void delete() {
        Contractor deleteContractor = contractorService.getAll().stream().findFirst().orElse(null);
        int size = contractorService.getAll().size();
        assert deleteContractor != null;
        contractorService.delete(deleteContractor.getContractorID());
        size -= 1;
        Assert.assertEquals(size, contractorService.getAll().size());
    }
}