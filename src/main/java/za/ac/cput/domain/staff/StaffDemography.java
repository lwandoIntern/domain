package za.ac.cput.domain.staff;

import java.util.Date;
import java.util.Objects;

public class StaffDemography {
    private String staffNum,genderId,raceId;

    private StaffDemography(){}
    public StaffDemography(String staffNum, String genderId, String raceId) {
        this.staffNum = staffNum;
        this.genderId = genderId;
        this.raceId = raceId;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getRaceId() {
        return raceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffDemography that = (StaffDemography) o;
        return staffNum.equals(that.staffNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffNum);
    }

    @Override
    public String toString() {
        return "StaffDemography{" +
                "staffNum='" + staffNum + '\'' +
                ", genderId='" + genderId + '\'' +
                ", raceId='" + raceId + '\'' +
                '}';
    }
}
