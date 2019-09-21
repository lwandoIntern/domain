package za.ac.cput.domain.staff;

import java.util.Objects;

public class StaffRole {
    private String staffNum,roleId;

    public StaffRole(String staffNum, String roleId) {
        this.staffNum = staffNum;
        this.roleId = roleId;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public String getRoleId() {
        return roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffRole staffRole = (StaffRole) o;
        return staffNum.equals(staffRole.staffNum) &&
                roleId.equals(staffRole.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffNum, roleId);
    }
}
