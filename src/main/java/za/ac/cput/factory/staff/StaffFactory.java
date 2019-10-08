package za.ac.cput.factory.staff;

import za.ac.cput.domain.staff.Staff;
import za.ac.cput.util.Helper;

public class StaffFactory {

    public static Staff createStaff(String firstName,String lastName){

        return new Staff.Builder()

                .name(firstName)
                .surname(lastName)
                .build();
    }
}
