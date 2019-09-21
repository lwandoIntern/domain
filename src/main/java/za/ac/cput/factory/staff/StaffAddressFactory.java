package za.ac.cput.factory.staff;

import za.ac.cput.domain.staff.StaffAddress;

public class StaffAddressFactory {
    public static StaffAddress createStaffAddress(String staffNum,String addressId){
        return new StaffAddress(staffNum,addressId);
    }
}
