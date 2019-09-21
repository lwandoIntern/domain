package za.ac.cput.repository.staff.impl;

import za.ac.cput.domain.staff.StaffAddress;
import za.ac.cput.repository.staff.StaffAddressRepository;

import java.util.HashSet;
import java.util.Set;

public class StaffAddressRepositoryImpl implements StaffAddressRepository {
    private static StaffAddressRepository staffAddressRepository = null;
    private Set<StaffAddress> staffAddressesDB;

    private StaffAddressRepositoryImpl(){
        this.staffAddressesDB = new HashSet<>();
    }

    public static StaffAddressRepository getStaffAddressRepository() {
        if (staffAddressRepository == null)staffAddressRepository = new StaffAddressRepositoryImpl();
        return staffAddressRepository;
    }

    private StaffAddress findStaffAddress(String id){
        return this.staffAddressesDB.stream()
                .filter(staffAddress -> staffAddress.getStaffNum().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }
    @Override
    public StaffAddress create(StaffAddress staffAddress) {
        this.staffAddressesDB.add(staffAddress);
        return staffAddress;
    }

    @Override
    public StaffAddress read(String s) {
        StaffAddress staffAddress = findStaffAddress(s);
        return staffAddress;
    }

    @Override
    public StaffAddress update(StaffAddress staffAddress) {
        StaffAddress toDelete = findStaffAddress(staffAddress.getStaffNum());
        if (toDelete != null){
            this.staffAddressesDB.remove(toDelete);
            return create(staffAddress);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        StaffAddress staffAddress = findStaffAddress(s);
        if (staffAddress != null)this.staffAddressesDB.remove(staffAddress);
    }

    @Override
    public Set<StaffAddress> getAll() {
        return this.staffAddressesDB;
    }
}
