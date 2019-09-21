package za.ac.cput.service.staff.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.staff.StaffDemography;
import za.ac.cput.repository.staff.StaffDemographyRepository;
import za.ac.cput.repository.staff.impl.StaffDemographyRepositoryImpl;
import za.ac.cput.service.staff.StaffDemographyService;

import java.util.Set;

@Service
public class StaffDemographyServiceImpl implements StaffDemographyService {
    private static StaffDemographyService staffDemographyService = null;
    private StaffDemographyRepository staffDemographyRepository;

    private StaffDemographyServiceImpl(){
        this.staffDemographyRepository = StaffDemographyRepositoryImpl.getStaffDemographyRepository();
    }

    public static StaffDemographyService getStaffDemographyService() {
        if (staffDemographyService == null)staffDemographyService = new StaffDemographyServiceImpl();
        return staffDemographyService;
    }

    @Override
    public StaffDemography create(StaffDemography staffDemography) {
        return this.staffDemographyRepository.create(staffDemography);
    }

    @Override
    public StaffDemography read(String s) {
        return this.staffDemographyRepository.read(s);
    }

    @Override
    public StaffDemography update(StaffDemography staffDemography) {
        return this.staffDemographyRepository.update(staffDemography);
    }

    @Override
    public void delete(String s) {
        this.staffDemographyRepository.delete(s);
    }

    @Override
    public Set<StaffDemography> getAll() {
        return this.staffDemographyRepository.getAll();
    }
}
