package za.ac.cput.repository.staff.impl;

import za.ac.cput.domain.staff.StaffRole;
import za.ac.cput.repository.staff.StaffRoleRepository;

import java.util.HashSet;
import java.util.Set;

public class StaffRoleRepositoryImpl implements StaffRoleRepository {
    private static StaffRoleRepository staffRoleRepository = null;
    private Set<StaffRole> staffRolesDB;

    private StaffRoleRepositoryImpl(){
        this.staffRolesDB = new HashSet<>();
    }

    public static StaffRoleRepository getStaffRoleRepository() {
        if (staffRoleRepository == null)staffRoleRepository = new StaffRoleRepositoryImpl();
        return staffRoleRepository;
    }

    private StaffRole findStaffRole(String id){
        return this.staffRolesDB.stream()
                .filter(staffRole -> staffRole.getStaffNum().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }
    @Override
    public StaffRole create(StaffRole staffRole) {
        this.staffRolesDB.add(staffRole);
        return staffRole;
    }

    @Override
    public StaffRole read(String s) {
        StaffRole staffRole = findStaffRole(s);
        return staffRole;
    }

    @Override
    public StaffRole update(StaffRole staffRole) {
        StaffRole toDelete = findStaffRole(staffRole.getStaffNum());
        if (toDelete != null){
            this.staffRolesDB.remove(toDelete);
            return create(staffRole);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        StaffRole staffRole = findStaffRole(s);
        if (staffRole != null)this.staffRolesDB.remove(staffRole);
    }

    @Override
    public Set<StaffRole> getAll() {
        return this.staffRolesDB;
    }
}
