package za.ac.cput.factory.staff;

import za.ac.cput.domain.staff.Staff;
import za.ac.cput.util.Helper;

public class StaffFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(StaffFactory.class);
    public static Staff createStaff(String firstName,String lastName){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Staff.Builder()
                .staffNum(id)
                .name(firstName)
                .surname(lastName)
                .build();
    }
}
