package za.ac.cput.domain.staff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StaffAddress implements Serializable {
    @Id
    @Column(name = "staff_number")
    private String staffNum;
    @Id
    @Column(name = "address_id")
    private String addressId;

    private StaffAddress(){}
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
        return staffNum.equals(that.staffNum) &&
                addressId.equals(that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffNum, addressId);
    }
}