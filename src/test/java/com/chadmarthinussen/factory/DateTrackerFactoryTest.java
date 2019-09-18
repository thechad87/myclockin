package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.AccessTypes.Date;
import com.chadmarthinussen.domain.TimeAndDateStamp.DateTracker;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public class DateTrackerFactoryTest {

    @Test
    public void getDateTracker() throws Exception {

        String dateTrID = "TR12";
        Date date = DateFactory.buildDate("D1","01", "12", "1988");
        DateTracker dateTrackerF = DateTrackerFactory.buildDateTracker(dateTrID, "T1", date);
        Assert.assertEquals(dateTrID, dateTrackerF.getDatetrackerID());
    }

}