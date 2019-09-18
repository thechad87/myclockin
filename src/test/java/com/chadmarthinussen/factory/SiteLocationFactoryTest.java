package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.Location.SiteLocation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public class SiteLocationFactoryTest {
    @Test
    public void getSiteLocation() throws Exception {

        String sitelocationId = "D123456";
        SiteLocation site = SiteLocationFactory
                .buildSiteLocation(sitelocationId, "2", "bloomberg", "stellenbosch", "cape town", "1234");
        Assert.assertEquals(sitelocationId , site.getSiteLocationID());
    }

}