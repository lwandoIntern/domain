package za.ac.cput.repository.location.impl;


import za.ac.cput.domain.location.Address;
import za.ac.cput.repository.location.AddressRepository;

import java.util.HashSet;
import java.util.Set;

public class AddressRepositoryImpl implements AddressRepository {
    private static AddressRepository addressRepository = null;
    private Set<Address> addresses;

    private AddressRepositoryImpl(){
        this.addresses = new HashSet<>();
    }

    public static AddressRepository getAddressRepository() {
        if (addressRepository == null)addressRepository = new AddressRepositoryImpl();
        return addressRepository;
    }
    private Address findAddress(String s){
        return this.addresses.stream().filter(address -> address.getAddressId().trim().equalsIgnoreCase(s)).findAny().orElse(null);
    }

    @Override
    public Address getByTown(String town) {
        return this.addresses.stream().filter(address -> address.getTown().equalsIgnoreCase(town)).findAny().orElse(null);
    }

    @Override
    public Address create(Address address) {
        this.addresses.add(address);
        return address;
    }

    @Override
    public Address read(String s) {
        Address address = findAddress(s);
        return address;
    }

    @Override
    public Address update(Address address) {
        Address toDelete = findAddress(address.getAddressId());
        if (toDelete != null){
            this.addresses.remove(toDelete);
            return create(address);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Address address = findAddress(s);
        if (address != null)this.addresses.remove(address);
    }

    @Override
    public Set<Address> getAll() {
        return this.addresses;
    }
}
