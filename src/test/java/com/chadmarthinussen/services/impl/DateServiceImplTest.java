package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.AccessTypes.Date;
import com.chadmarthinussen.factory.DateFactory;
import com.chadmarthinussen.services.DateService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DateServiceImplTest {

    private static DateService dateService;
    private static Date date;

    @BeforeClass
    public static void setUp() {
        dateService = DateServiceImpl.getService();
        date = DateFactory.buildDate("A-01-06-2019", "01", "06", "2019");
        dateService.create(date);
    }

    @Test
    public void getArtFormService() {
        Assert.assertNotNull(dateService);
    }

    @Test
    public void create() {
        date  = DateFactory.buildDate("A-01-06-2019", "01", "06", "2019");
        dateService.create(date);
        Assert.assertEquals(date, dateService.create(date));
    }

    @Test
    public void read() {
        date = dateService.read(date.getDateID());
        Assert.assertSame(date, dateService.read(date.getDateID()));
    }

    @Test
    public void update() {
        String dateId = "a_01-02-1990";
        Date dateTemp= new Date.Builder().copy(date).dateID(dateId).build();
        dateService.create(dateTemp);
        Assert.assertSame(dateId, dateService.read(date.getDateID()));
    }

    @Test
    public void delete() {
        date  = dateService.getAll().stream().findFirst().orElse(null);
        int size = dateService.getAll().size();
        assert dateService != null;
        dateService.delete(date.getDateID());
        size -= 1;
        Assert.assertEquals(size, dateService.getAll().size());
    }
}