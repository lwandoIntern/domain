package za.ac.cput.repository.location;

import za.ac.cput.domain.location.Address;
import za.ac.cput.repository.IRepository;

public interface AddressRepository extends IRepository<Address,String> {
    Address getByTown(String town);
}
