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
        return this.staffRepository.save(staff);
    }

    @Override
    public Staff read(String s) {
        return this.staffRepository.getOne(s);
    }

    @Override
    public Staff update(Staff staff) {
        return this.staffRepository.save(staff);
    }

    @Override
    public void delete(String s) {
        this.staffRepository.deleteById(s);
    }

    @Override
    public Set<Staff> getAll() {
        Set set = new HashSet();
        set.addAll(this.staffRepository.findAll());
        return set;
    }
}
