package za.ac.cput.service.staff.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.staff.StaffAddress;
import za.ac.cput.repository.staff.StaffAddressRepository;
import za.ac.cput.repository.staff.impl.StaffAddressRepositoryImpl;
import za.ac.cput.service.staff.StaffAddressService;

import java.util.Set;

@Service
public class StaffAddressServiceImpl implements StaffAddressService {
    private static StaffAddressService staffAddressService = null;
    private StaffAddressRepository staffAddressRepository;

    private StaffAddressServiceImpl(){
        this.staffAddressRepository = StaffAddressRepositoryImpl.getStaffAddressRepository();
    }

    public static StaffAddressService getStaffAddressService() {
        if (staffAddressService == null)staffAddressService = new StaffAddressServiceImpl();
        return staffAddressService;
    }

    @Override
    public StaffAddress create(StaffAddress staffAddress) {
        return this.staffAddressRepository.create(staffAddress);
    }

    @Override
    public StaffAddress read(String s) {
        return this.staffAddressRepository.read(s);
    }

    @Override
    public StaffAddress update(StaffAddress staffAddress) {
        return this.staffAddressRepository.update(staffAddress);
    }

    @Override
    public void delete(String s) {
        this.staffAddressRepository.delete(s);
    }

    @Override
    public Set<StaffAddress> getAll() {
        return this.staffAddressRepository.getAll();
    }
}
