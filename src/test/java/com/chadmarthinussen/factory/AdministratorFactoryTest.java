package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.UserlType.Administrator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class AdministratorFactoryTest {


        @Test
        public void getAdministrator(){

            boolean isadmin = true;
            boolean canEdit = true;
            Administrator One = AdministratorFactory.getAdministrator(isadmin, canEdit);
            System.out.println(One);
            Assert.assertEquals( canEdit, One.getCanEdit());
        }
}


//    private boolean isAdministrator;
//    private String canWrite;