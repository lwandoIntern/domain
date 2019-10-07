package za.ac.cput.domain.staff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StaffRole implements Serializable {
    @Id
    @Column(name = "staff_number")
    private String staffNum;
    @Id
    @Column(name = "role_id")
    private String roleId;

    private StaffRole(){}
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
