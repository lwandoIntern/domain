package za.ac.cput.domain.staff;

import java.util.Date;
import java.util.Objects;

public class StaffDemography {
    private String staffNum,genderId,raceId,staffTitle;
    private Date dateOfBirth;

    private StaffDemography(){}
    public StaffDemography(String staffNum, String genderId, String raceId, String staffTitle, Date dateOfBirth) {
        this.staffNum = staffNum;
        this.genderId = genderId;
        this.raceId = raceId;
        this.staffTitle = staffTitle;
        this.dateOfBirth = dateOfBirth;
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

    public String getStaffTitle() {
        return staffTitle;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
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
                ", staffTitle='" + staffTitle + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
