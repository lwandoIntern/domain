package za.ac.cput.domain.staff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class StaffAddress {
    @Id
    @Column(name = "staff_id",nullable = false,columnDefinition = "VARCHAR(15)")
    private String staffNum;
    private String addressId;

    public StaffAddress(String staffNum, String addressId) {
        this.staffNum = staffNum;
        this.addressId = addressId;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public String getAddressId() {
        return addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffAddress that = (StaffAddress) o;
        return staffNum == that.staffNum &&
                addressId == that.addressId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffNum, addressId);
    }
}
