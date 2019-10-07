package za.ac.cput.service.location;


import za.ac.cput.domain.location.Address;
import za.ac.cput.service.IService;

public interface AddressService extends IService<Address,String> {
    Address getByTown(String town);
}
