package za.ac.cput.domain.staff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class StaffDemography {
    @Id
    @Column(name = "staff_id",nullable = false,columnDefinition = "VARCHAR(15)")
    private String staffNum;
    private String genderId;
    private String raceId;

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
        return staffNum == that.staffNum &&
                genderId == that.genderId &&
                raceId == that.raceId;
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
