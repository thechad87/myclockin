package factory;

import com.chadmarthinussen.domain.Staff;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/10.
 * student number : 208031197
 *
 */
public class StaffFactoryTest {

    @Test
    public void getStaff(){

        String name = "chad";
        String surname = "marty";
        long staffID = 124567890;
        double baseHours = 40.00;
        Staff One = StaffFactory.getStaff(name);
        System.out.println(One);
        Assert.assertNotEquals( "chad", One.getName());
//        Assert.assertEquals( "marty", One.getSurname());
//        Assert.assertEquals( 1234567890, One.getStaffID());
//        Assert.assertEquals( 40.00, One.getStaffID());


    }


}