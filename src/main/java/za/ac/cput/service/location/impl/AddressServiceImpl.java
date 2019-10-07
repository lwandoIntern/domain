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
        return getAll().stream()
                .filter(address -> address.getTown().equalsIgnoreCase(town))
                .findAny()
                .get();
    }

    @Override
    public Address create(Address address) {
        this.addressRepository.save(address);
        return this.addressRepository.getOne(address.getAddressId());
    }

    @Override
    public Address read(String s) {
        return this.addressRepository.getOne(s);
    }

    @Override
    public Address update(Address address) {
        Address address1 = read(address.getAddressId());
        if (address1 == address){
            this.addressRepository.delete(address1);
            return create(address);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        this.addressRepository.deleteById(s);
    }

    @Override
    public Set<Address> getAll() {
        Set<Address> addresses = new HashSet<>();
        addresses.addAll(this.addressRepository.findAll());
        return addresses;
    }
}
