package za.ac.cput.service.staff.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.staff.Staff;
import za.ac.cput.repository.staff.StaffRepository;
import za.ac.cput.service.staff.StaffService;


import java.util.HashSet;
import java.util.Set;

@Service
public class StaffServiceImpl implements StaffService {
    private static StaffService staffService = null;
    @Autowired
    private StaffRepository staffRepository;

    private StaffServiceImpl(){}

    public static StaffService getStaffService() {
        if (staffService == null)staffService = new StaffServiceImpl();
        return staffService;
    }

    @Override
    public Staff create(Staff staff) {
        this.staffRepository.save(staff);
        return this.staffRepository.getOne(staff.getStaffNum());
    }

    @Override
    public Staff read(String s) {
        return this.staffRepository.getOne(s);
    }

    @Override
    public Staff update(Staff staff) {
        Staff staff1 = read(staff.getStaffNum());
        if (staff1 == staff){
            delete(staff1.getStaffNum());
            return create(staff);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (read(s) != null)
            this.staffRepository.deleteById(s);
    }

    @Override
    public Set<Staff> getAll() {
        Set<Staff> staffSet = new HashSet<>();
        staffSet.addAll(this.staffRepository.findAll());
        return staffSet;
    }
}
