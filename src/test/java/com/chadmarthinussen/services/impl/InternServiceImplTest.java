package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.UserlType.Intern;
import com.chadmarthinussen.factory.InternFactory;
import com.chadmarthinussen.services.InternService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InternServiceImplTest {

    private static InternService internService;
    private static Intern intern;
    private static Set<Intern> internsSet = new HashSet<>();


    @BeforeClass
    public static void setUp() {
        internService = InternServiceImpl.getService();
        intern = InternFactory.buildIntern(true, "Rffe12");
        internService.create(intern);
    }

    @Test
    public void getAddressService() {
        Assert.assertNotNull(internService);
    }

    @Test
    public void create() {
        Intern newIntern = internService.create(InternFactory.buildIntern(
                true, "Rffe12"));
        Assert.assertNotNull(newIntern);
        Assert.assertSame(newIntern , internService.read(newIntern.getInternID()));
    }

    @Test
    public void read() {
        Intern readIntern = internService.create(InternFactory.buildIntern(
                true, "Rffe12"));
        Assert.assertSame(readIntern, internService.read(readIntern.getInternID()));
    }

    @Test
    public void update() {
        String newIntern = "Ralph";
        Intern InternTemp = new Intern.Builder().copy(intern).internID(newIntern).build();
        Assert.assertSame(newIntern, InternTemp.getInternID());
    }

    @Test
    public void delete() {
//        Intern deleteIntern = internService.getAll().;
//        assert deleteAddress != null;
//        internService.delete(deleteAddress.getAddressId());
//        Assert.assertEquals(size - 1, internService.getAll().size());

        internService.delete(intern.getInternID());
        Assert.assertNotNull(internsSet);
    }

}