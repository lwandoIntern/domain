package za.ac.cput.service.staff.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.staff.StaffDemography;
import za.ac.cput.repository.staff.StaffDemographyRepository;
import za.ac.cput.service.staff.StaffDemographyService;


import java.util.HashSet;
import java.util.Set;

@Service
public class StaffDemographyServiceImpl implements StaffDemographyService {
    private static StaffDemographyService staffDemographyService = null;
    @Autowired
    private StaffDemographyRepository staffDemographyRepository;

    private StaffDemographyServiceImpl(){}

    public static StaffDemographyService getStaffDemographyService() {
        if (staffDemographyService == null)staffDemographyService = new StaffDemographyServiceImpl();
        return staffDemographyService;
    }

    @Override
    public StaffDemography create(StaffDemography staffDemography) {
        this.staffDemographyRepository.save(staffDemography);
        return read(staffDemography.getStaffNum());
    }

    @Override
    public StaffDemography read(String s) {
        return this.staffDemographyRepository.getOne(s);
    }

    @Override
    public StaffDemography update(StaffDemography staffDemography) {
        StaffDemography staffDemography1 = read(staffDemography.getStaffNum());
        if (staffDemography1 == staffDemography){
            delete(staffDemography1.getStaffNum());
            create(staffDemography);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (read(s) != null)
            this.staffDemographyRepository.deleteById(s);
    }

    @Override
    public Set<StaffDemography> getAll() {
        Set<StaffDemography> staffDemographies = new HashSet<>();
        staffDemographies.addAll(this.staffDemographyRepository.findAll());
        return staffDemographies;
    }
}
