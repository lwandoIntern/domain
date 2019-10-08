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

    private StaffDemographyServiceImpl() {

    }

    public static StaffDemographyService getStaffDemographyService() {
        if (staffDemographyService == null) staffDemographyService = new StaffDemographyServiceImpl();
        return staffDemographyService;
    }

    @Override
    public StaffDemography create(StaffDemography staffDemography) {
        return this.staffDemographyRepository.save(staffDemography);
    }

    @Override
    public StaffDemography read(String s) {
        return this.staffDemographyRepository.getOne(s);
    }

    @Override
    public StaffDemography update(StaffDemography staffDemography) {
        return this.staffDemographyRepository.save(staffDemography);
    }

    @Override
    public void delete(String s) {
        this.staffDemographyRepository.deleteById(s);
    }

    @Override
    public Set<StaffDemography> getAll() {
        Set set = new HashSet();
        set.addAll(this.staffDemographyRepository.findAll());
        return set;
    }
}