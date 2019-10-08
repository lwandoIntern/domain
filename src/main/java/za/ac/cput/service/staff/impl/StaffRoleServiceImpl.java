package za.ac.cput.service.staff.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.text.IntHashtable;
import za.ac.cput.domain.staff.StaffRole;
import za.ac.cput.repository.staff.StaffRoleRepository;

import za.ac.cput.service.staff.StaffRoleService;

import java.util.HashSet;
import java.util.Set;

@Service
public class StaffRoleServiceImpl implements StaffRoleService {
    private static StaffRoleService staffRoleService = null;
    @Autowired
    private StaffRoleRepository staffRoleRepository;

    private StaffRoleServiceImpl(){}

    public static StaffRoleService getStaffRoleService() {
        if (staffRoleService == null)staffRoleService = new StaffRoleServiceImpl();
        return staffRoleService;
    }

    @Override
    public StaffRole create(StaffRole staffRole) {
        return this.staffRoleRepository.save(staffRole);
    }

    @Override
    public StaffRole read(String s) {
        return this.staffRoleRepository.getOne(s);
    }

    @Override
    public StaffRole update(StaffRole staffRole) {
        return this.staffRoleRepository.save(staffRole);
    }

    @Override
    public void delete(String s) {
        this.staffRoleRepository.deleteById(s);
    }

    @Override
    public Set<StaffRole> getAll() {
        Set set = new HashSet();
        set.addAll(this.staffRoleRepository.findAll());
        return set;
    }
}
