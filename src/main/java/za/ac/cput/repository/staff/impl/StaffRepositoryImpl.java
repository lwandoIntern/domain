package za.ac.cput.repository.staff.impl;

import za.ac.cput.domain.staff.Staff;
import za.ac.cput.repository.staff.StaffRepository;

import java.util.HashSet;
import java.util.Set;

public class StaffRepositoryImpl implements StaffRepository {
    private static StaffRepository staffRepository = null;
    private Set<Staff> staffDB;

    private StaffRepositoryImpl(){
        this.staffDB = new HashSet<>();
    }

    public static StaffRepository getStaffRepository() {
        if (staffRepository == null)staffRepository = new StaffRepositoryImpl();
        return staffRepository;
    }
    private Staff findStaff(String staffId){
        return this.staffDB.stream()
                .filter(staff -> staff.getStaffNum().trim().equalsIgnoreCase(staffId))
                .findAny()
                .orElse(null);
    }

    @Override
    public Staff create(Staff staff) {
        this.staffDB.add(staff);
        return staff;
    }

    @Override
    public Staff read(String s) {
        Staff staff = findStaff(s);
        return staff;
    }

    @Override
    public Staff update(Staff staff) {
        Staff toDelete = findStaff(staff.getStaffNum());
        if (toDelete != null){
            this.staffDB.remove(toDelete);
            return create(staff);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Staff staff = findStaff(s);
        if (staff != null)this.staffDB.remove(staff);
    }

    @Override
    public Set<Staff> getAll() {
        return this.staffDB;
    }
}
