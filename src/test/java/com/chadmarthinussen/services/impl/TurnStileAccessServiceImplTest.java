package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.AccessTypes.Time;
import com.chadmarthinussen.domain.AccessTypes.TurnStileAccess;
import com.chadmarthinussen.factory.TimeFactory;
import com.chadmarthinussen.factory.TurnStileAccessFactory;
import com.chadmarthinussen.services.TurnStileAccessService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TurnStileAccessServiceImplTest {



    private static TurnStileAccessService turnStileAccessService;
    private static TurnStileAccess turnStyleAccess;
    Time times = TimeFactory.buildTime("A134", "01", "21", "23");

//    private static String time;

    @BeforeClass
    public static void setUp() {

        Time timesSetup =  TimeFactory.buildTime("A134", "01", "21", "23");
        turnStileAccessService = TurnStileAccessServiceImpl.getService();
        turnStyleAccess = TurnStileAccessFactory.buildTurnStileAccess("A123", true, timesSetup);
        turnStileAccessService.create(turnStyleAccess);

    }

    @Test
    public void getTurnStileAccessService() {
        Assert.assertNotNull(turnStileAccessService);
    }

    @Test
    public void create() {
        Time createTime = TimeFactory.buildTime("T123", "54" , "34", "7");
        TurnStileAccess newTurnStileAccess = turnStileAccessService.create(TurnStileAccessFactory.buildTurnStileAccess(
                "15", true, createTime));
        Assert.assertNotNull(newTurnStileAccess);
        Assert.assertSame(newTurnStileAccess, turnStileAccessService.read(newTurnStileAccess.getTurnStileAccessID()));
    }

    @Test
    public void read() {
        TurnStileAccess readTurnStileAccess = turnStileAccessService.create(TurnStileAccessFactory.buildTurnStileAccess(
                "25", true, times));
        Assert.assertSame(readTurnStileAccess, turnStileAccessService.read(readTurnStileAccess.getTurnStileAccessID()));
    }

    @Test
    public void update() {
        String newTurnStileAccessID = "A134";
        TurnStileAccess addressTemp = new TurnStileAccess.Builder().copy(turnStyleAccess).turnStileAccessID(newTurnStileAccessID).build();
        Assert.assertSame(newTurnStileAccessID, addressTemp.getTurnStileAccessID());
    }

    @Test
    public void delete() {
        TurnStileAccess deleteTurnStileAccess = turnStileAccessService.getAll().stream().findFirst().orElse(null);
        int size = turnStileAccessService.getAll().size();
        assert deleteTurnStileAccess != null;
        turnStileAccessService.delete(deleteTurnStileAccess.getTurnStileAccessID());
        Assert.assertEquals(size - 1, turnStileAccessService.getAll().size());
    }
}