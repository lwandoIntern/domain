package za.ac.cput.service.staff.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.staff.Staff;
import za.ac.cput.repository.staff.StaffRepository;
import za.ac.cput.repository.staff.impl.StaffRepositoryImpl;
import za.ac.cput.service.staff.StaffService;

import java.util.Set;

@Service
public class StaffServiceImpl implements StaffService {
    private static StaffService staffService = null;
    private StaffRepository staffRepository;

    private StaffServiceImpl(){
        this.staffRepository = StaffRepositoryImpl.getStaffRepository();
    }

    public static StaffService getStaffService() {
        if (staffService == null)staffService = new StaffServiceImpl();
        return staffService;
    }

    @Override
    public Staff create(Staff staff) {
        return this.staffRepository.create(staff);
    }

    @Override
    public Staff read(String s) {
        return this.staffRepository.read(s);
    }

    @Override
    public Staff update(Staff staff) {
        return this.staffRepository.update(staff);
    }

    @Override
    public void delete(String s) {
        this.staffRepository.delete(s);
    }

    @Override
    public Set<Staff> getAll() {
        return this.staffRepository.getAll();
    }
}
