package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.AccessTypes.Time;
import com.chadmarthinussen.domain.AccessTypes.TurnStileAccess;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public class TurnStileAccessFactoryTest {
    @Test
    public void getTurnStileAccess() throws Exception {

        String turnStileAccessID = "dJ2k3s";
        Time time = TimeFactory.buildTime("T1_01", "23", "23", "12");
        TurnStileAccess turnStileAccess = TurnStileAccessFactory
                .buildTurnStileAccess(turnStileAccessID, true, time);
        Assert.assertEquals(turnStileAccessID, turnStileAccess.getTurnStileAccessID());
    }

}