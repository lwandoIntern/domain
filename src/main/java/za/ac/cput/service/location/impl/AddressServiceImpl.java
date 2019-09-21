package za.ac.cput.service.location.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.location.Address;
import za.ac.cput.repository.location.AddressRepository;
import za.ac.cput.repository.location.impl.AddressRepositoryImpl;
import za.ac.cput.service.location.AddressService;

import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {
    private static AddressService addressService = null;
    private AddressRepository addressRepository;

    private AddressServiceImpl(){
        this.addressRepository = AddressRepositoryImpl.getAddressRepository();
    }

    public static AddressService getAddressService() {
        if (addressService ==null)addressService = new AddressServiceImpl();
        return addressService;
    }

    @Override
    public Address getByTown(String town) {
        return this.addressRepository.getByTown(town);
    }

    @Override
    public Address create(Address address) {
        return this.addressRepository.create(address);
    }

    @Override
    public Address read(String s) {
        return this.addressRepository.read(s);
    }

    @Override
    public Address update(Address address) {
        return this.addressRepository.update(address);
    }

    @Override
    public void delete(String s) {
        this.addressRepository.delete(s);
    }

    @Override
    public Set<Address> getAll() {
        return this.addressRepository.getAll();
    }
}
