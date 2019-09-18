package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.UserlType.Administrator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class AdministratorFactoryTest {

        @Test
        public void getAdministrator(){
            String id = "36456";
            boolean isadmin = true;
            boolean canEdit = true;
            Administrator One = AdministratorFactory.buildAdministrator(id,isadmin, canEdit);
            System.out.println(One);
            Assert.assertEquals( canEdit, One.getCanEdit());
        }
}

