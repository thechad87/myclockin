package factory;

import com.chadmarthinussen.domain.Staff;

/**
 * Created by ChadMarthinussen2 on 2019/04/10.
 * student number : 208031197
 *
 */
public class StaffFactory {

    public static Staff getStaff(String name, String surname, long staffID, double baseHours){
        return new Staff.Builder().name(name).surname(surname).staffID(staffID).baseHours(baseHours).build();
    }
}
