package za.ac.cput.domain.staff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class StaffRole {
    @Id
    @Column(name = "staff_id",nullable = false,columnDefinition = "VARCHAR(15)")
    private String staffNum;
    private String roleId;

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
        return staffNum == staffRole.staffNum &&
                roleId == staffRole.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffNum, roleId);
    }
}
