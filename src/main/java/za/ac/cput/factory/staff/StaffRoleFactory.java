package za.ac.cput.factory.staff;

import za.ac.cput.domain.staff.StaffRole;

public class StaffRoleFactory {
    public static StaffRole createStaffRole(String staffNum, String roleId){
        return new StaffRole(staffNum,roleId);
    }
}
