package za.ac.cput.service.staff.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.staff.StaffAddress;
import za.ac.cput.repository.staff.StaffAddressRepository;

import za.ac.cput.service.staff.StaffAddressService;

import java.util.HashSet;
import java.util.Set;

@Service
public class StaffAddressServiceImpl implements StaffAddressService {
    private static StaffAddressService staffAddressService = null;
    @Autowired
    private StaffAddressRepository staffAddressRepository;

    private StaffAddressServiceImpl(){

    }

    public static StaffAddressService getStaffAddressService() {
        if (staffAddressService == null)staffAddressService = new StaffAddressServiceImpl();
        return staffAddressService;
    }


    @Override
    public StaffAddress create(StaffAddress staffAddress) {
        return this.staffAddressRepository.save(staffAddress);
    }

    @Override
    public StaffAddress read(String s) {
        return this.staffAddressRepository.getOne(s);
    }

    @Override
    public StaffAddress update(StaffAddress staffAddress) {
        return this.staffAddressRepository.save(staffAddress);
    }

    @Override
    public void delete(String s) {
        this.staffAddressRepository.deleteById(s);
    }

    @Override
    public Set<StaffAddress> getAll() {
        Set set = new HashSet();
        set.addAll(this.staffAddressRepository.findAll());
        return set;
    }
}
