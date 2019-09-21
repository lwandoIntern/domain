package za.ac.cput.domain.staff;

import java.util.Objects;

public class StaffAddress {
    private String staffNum,addressId;

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
