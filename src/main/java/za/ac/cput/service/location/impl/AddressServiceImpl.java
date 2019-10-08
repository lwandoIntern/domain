package za.ac.cput.service.location.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.location.Address;
import za.ac.cput.repository.location.AddressRepository;
import za.ac.cput.service.location.AddressService;

import java.util.HashSet;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {
    private static AddressService addressService = null;
    @Autowired
    private AddressRepository addressRepository;

    private AddressServiceImpl(){}

    public static AddressService getAddressService() {
        if (addressService ==null)addressService = new AddressServiceImpl();
        return addressService;
    }

    @Override
    public Address getByTown(String town) {
        return this.addressRepository.findAll().stream()
                .filter(address -> address.getTown().equalsIgnoreCase(town))
                .findAny()
                .get();
    }

    @Override
    public Address create(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public Address read(String s) {
        return this.addressRepository.getOne(s);
    }

    @Override
    public Address update(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public void delete(String s) {
        this.addressRepository.deleteById(s);
    }

    @Override
    public Set<Address> getAll() {
        Set set = new HashSet();
        set.addAll(this.addressRepository.findAll());
        return set;
    }
}
