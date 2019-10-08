package za.ac.cput.factory.staff;

import za.ac.cput.domain.staff.StaffDemography;

public class StaffDemographyFactory {
    public static StaffDemography createStaffDemography(String staffNum, String genderId, String raceId){
        return new StaffDemography(staffNum,genderId,raceId);
    }
}
