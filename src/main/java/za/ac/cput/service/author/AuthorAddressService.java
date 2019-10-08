package za.ac.cput.service.author;


import org.springframework.stereotype.Repository;
import za.ac.cput.domain.author.AuthorAddress;
import za.ac.cput.service.IService;

@Repository
public interface AuthorAddressService extends IService<AuthorAddress,String> {
}
