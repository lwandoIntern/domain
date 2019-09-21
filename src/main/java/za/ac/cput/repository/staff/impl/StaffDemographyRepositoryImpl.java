package za.ac.cput.repository.staff.impl;

import za.ac.cput.domain.staff.StaffDemography;
import za.ac.cput.repository.staff.StaffDemographyRepository;

import java.util.HashSet;
import java.util.Set;

public class StaffDemographyRepositoryImpl implements StaffDemographyRepository {
    private static StaffDemographyRepository staffDemographyRepository = null;
    private Set<StaffDemography> staffDemographiesDB;
    private StaffDemographyRepositoryImpl(){
        this.staffDemographiesDB = new HashSet<>();
    }

    public static StaffDemographyRepository getStaffDemographyRepository() {
        if (staffDemographyRepository == null)staffDemographyRepository = new StaffDemographyRepositoryImpl();
        return staffDemographyRepository;
    }

    private StaffDemography findStaffDemography(String s){
        return this.staffDemographiesDB.stream()
                .filter(staffDemography -> staffDemography.getStaffNum().trim().equalsIgnoreCase(s))
                .findAny()
                .orElse(null);
    }
    @Override
    public StaffDemography create(StaffDemography staffDemography) {
        this.staffDemographiesDB.add(staffDemography);
        return staffDemography;
    }

    @Override
    public StaffDemography read(String s) {
        StaffDemography staffDemography = findStaffDemography(s);
        return staffDemography;
    }

    @Override
    public StaffDemography update(StaffDemography staffDemography) {
        StaffDemography toDelete = findStaffDemography(staffDemography.getStaffNum());
        if (toDelete != null){
            this.staffDemographiesDB.remove(toDelete);
            return create(staffDemography);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        StaffDemography staffDemography = findStaffDemography(s);
        if (staffDemography != null)this.staffDemographiesDB.remove(staffDemography);
    }

    @Override
    public Set<StaffDemography> getAll() {
        return this.staffDemographiesDB;
    }
}
