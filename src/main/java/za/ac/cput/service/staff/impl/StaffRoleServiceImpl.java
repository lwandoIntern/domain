package za.ac.cput.service.staff.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.staff.StaffRole;
import za.ac.cput.repository.staff.StaffRoleRepository;
import za.ac.cput.repository.staff.impl.StaffRoleRepositoryImpl;
import za.ac.cput.service.staff.StaffRoleService;

import java.util.Set;

@Service
public class StaffRoleServiceImpl implements StaffRoleService {
    private static StaffRoleService staffRoleService = null;
    private StaffRoleRepository staffRoleRepository;

    private StaffRoleServiceImpl(){
        this.staffRoleRepository = StaffRoleRepositoryImpl.getStaffRoleRepository();
    }
    @Override
    public StaffRole create(StaffRole staffRole) {
        return this.staffRoleRepository.create(staffRole);
    }

    @Override
    public StaffRole read(String s) {
        return this.staffRoleRepository.read(s);
    }

    @Override
    public StaffRole update(StaffRole staffRole) {
        return this.staffRoleRepository.update(staffRole);
    }

    @Override
    public void delete(String s) {
        this.staffRoleRepository.delete(s);
    }

    @Override
    public Set<StaffRole> getAll() {
        return this.staffRoleRepository.getAll();
    }
}
