package za.ac.cput.service.staff.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        this.staffRoleRepository.save(staffRole);
        return this.staffRoleRepository.getOne(staffRole.getStaffNum());
    }

    @Override
    public StaffRole read(String s) {
        return this.staffRoleRepository.getOne(s);
    }

    @Override
    public StaffRole update(StaffRole staffRole) {
        StaffRole staffRole1 = read(staffRole.getStaffNum());
        if (staffRole1 == staffRole){
            read(staffRole1.getStaffNum());
            return create(staffRole);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (read(s) != null)
            this.staffRoleRepository.deleteById(s);
    }

    @Override
    public Set<StaffRole> getAll() {
        Set<StaffRole>staffRoles = new HashSet<>();
        staffRoles.addAll(this.staffRoleRepository.findAll());
        return staffRoles;
    }
}
